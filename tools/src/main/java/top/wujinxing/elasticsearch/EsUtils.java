package top.wujinxing.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.*;
import co.elastic.clients.elasticsearch._types.mapping.Property;
import co.elastic.clients.elasticsearch._types.query_dsl.*;
import co.elastic.clients.elasticsearch.cat.IndicesResponse;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.core.search.TotalHitsRelation;
import co.elastic.clients.elasticsearch.indices.*;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.*;

/**
 * @author 01397208
 * @date 2023/9/27
 * <p>
 * es version：7.19.9
 */
@Slf4j
public class EsUtils {

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:9200";
        ElasticsearchClient esClient = getEsClient(url);
        String indexName = "products";
    }

    public static ElasticsearchClient getEsClient(String serverUrl) throws IOException {

        RestClient restClient = RestClient.builder(HttpHost.create(serverUrl)).build();

        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        ElasticsearchClient esClient = new ElasticsearchClient(transport);
        // log.info("{}", esClient.info());
        return esClient;
    }


    public static void createIndex(ElasticsearchClient esClient, String indexName) throws IOException {
        if (existsIndex(esClient, indexName)) {
            log.info("index name: {} exists!", indexName);
        } else {
            CreateIndexResponse response = esClient.indices().create(c -> c.index(indexName));
            log.info("create index name: {}, ack: {}", indexName, response.acknowledged());
        }
    }


    public static boolean existsIndex(ElasticsearchClient esClient, String indexName) throws IOException {
        BooleanResponse exists = esClient.indices().exists(c -> c.index(indexName));
        return exists.value();
    }


    public static void getIndex(ElasticsearchClient esClient, String indexName) throws IOException {
        GetIndexResponse getIndexResponse = esClient.indices().get(s -> s.index(indexName));
        Map<String, IndexState> result = getIndexResponse.result();
        result.forEach((k, v) -> log.info("get index key: {}, value= {}", k, v));

        // 查看全部索引
        IndicesResponse indicesResponse = esClient.cat().indices();
        indicesResponse.valueBody().forEach(i ->
                log.info("get all index, health: {}, status: {}, uuid: {}", i.health(), i.status(), i.uuid()));
    }


    public static void delIndex(ElasticsearchClient esClient, String indexName) throws IOException {
        if (existsIndex(esClient, indexName)) {
            log.info("index: {} exists!", indexName);
            DeleteIndexResponse deleteIndexResponse = esClient.indices().delete(s -> s.index(indexName));
            log.info("删除索引操作结果：{}", deleteIndexResponse.acknowledged());
        } else {
            log.info("index: {} not found!", indexName);
        }
    }


    public static void updateMappings(ElasticsearchClient esClient, String indexName, Map<String, Property> documentMap) throws IOException {
        PutMappingRequest putMappingRequest = PutMappingRequest.of(m -> m.index(indexName).properties(documentMap));
        PutMappingResponse putMappingResponse = esClient.indices().putMapping(putMappingRequest);
        boolean acknowledged = putMappingResponse.acknowledged();
        log.info("update mappings ack: {}", acknowledged);
    }

    public static void addOneDocument(ElasticsearchClient esClient, String indexName, Product product) throws IOException {
        IndexResponse indexResponse = esClient.index(i -> i.index(indexName).id(product.getId()).document(product));
        log.info("add one document result: {}", indexResponse.result().jsonValue());
    }


    public static void batchAddDocument(ElasticsearchClient esClient, String indexName, List<Product> products) throws IOException {
        List<BulkOperation> bulkOperations = new ArrayList<>();
        products.forEach(p -> bulkOperations.add(BulkOperation.of(b -> b.index(c -> c.id(p.getId()).document(p)))));
        BulkResponse bulkResponse = esClient.bulk(s -> s.index(indexName).operations(bulkOperations));
        bulkResponse.items().forEach(b -> log.info("bulk response result = {}", b.result()));
        log.error("bulk response.error() = {}", bulkResponse.errors());

    }


    public static void getDocument(ElasticsearchClient esClient, String indexName, String id) throws IOException {
        GetResponse<Product> getResponse = esClient.get(s -> s.index(indexName).id(id), Product.class);
        if (getResponse.found()) {
            Product source = getResponse.source();
            log.info("get response: {}", source);
        }
        // 判断文档是否存在
        BooleanResponse booleanResponse = esClient.exists(s -> s.index(indexName).id(id));
        log.info("文档id:{},是否存在：{}", id, booleanResponse.value());
    }


    public static void updateDocument(ElasticsearchClient esClient, String indexName, Product product) throws IOException {
        UpdateResponse<Product> updateResponse = esClient.update(s -> s.index(indexName).id(product.getId()).doc(product), Product.class);
        log.info("update doc result: {}", updateResponse.result());
    }

    public static void deleteDocument(ElasticsearchClient esClient, String indexName, String id) {
        try {
            DeleteResponse deleteResponse = esClient.delete(s -> s.index(indexName).id(id));
            log.info("del doc result: {}", deleteResponse.result());
        } catch (IOException e) {
            log.error("del doc failed, error: ", e);
        }
    }


    public static void batchDeleteDocument(ElasticsearchClient esClient, String indexName, List<String> ids) {
        List<BulkOperation> bulkOperations = new ArrayList<>();
        ids.forEach(a -> bulkOperations.add(BulkOperation.of(b -> b.delete(c -> c.id(a)))));
        try {
            BulkResponse bulkResponse = esClient.bulk(a -> a.index(indexName).operations(bulkOperations));
            bulkResponse.items().forEach(a -> log.info("batch del result: {}", a.result()));
            log.error("batch del bulk resp errors: {}", bulkResponse.errors());
        } catch (IOException e) {
            log.error("batch del doc failed, error: ", e);
        }
    }


    public static void searchOne(ElasticsearchClient esClient, String indexName, String searchText) throws IOException {
        SearchResponse<Product> searchResponse = esClient.search(s -> s
                .index(indexName)
                // 搜索请求的查询部分（搜索请求也可以有其他组件，如聚合）
                .query(q -> q
                        // 在众多可用的查询变体中选择一个。我们在这里选择匹配查询（全文搜索）
                        .match(t -> t
                                .field("name")
                                .query(searchText))), Product.class);
        TotalHits total = searchResponse.hits().total();
        boolean isExactResult = total != null && total.relation() == TotalHitsRelation.Eq;
        if (isExactResult) {
            log.info("search has: {} results", total.value());
        } else {
            log.info("search more than : {} results", total.value());
        }
        List<Hit<Product>> hits = searchResponse.hits().hits();
        for (Hit<Product> hit : hits) {
            Product source = hit.source();
            log.info("Found result: {}", source);
        }
    }

    public static void searchPage(ElasticsearchClient esClient, String indexName, String searchText) throws IOException {
        Query query = RangeQuery.of(r -> r
                        .field("age")
                        .gte(JsonData.of(8)))
                ._toQuery();

        SearchResponse<Product> searchResponse = esClient.search(s -> s
                        .index(indexName)
                        .query(q -> q
                                .bool(b -> b.must(query)))
                        // 分页查询，从第0页开始查询四个doc
                        .from(0)
                        .size(4)
                        // 按id降序排列
                        .sort(f -> f
                                .field(o -> o
                                        .field("age").order(SortOrder.Desc))),
                Product.class);
        List<Hit<Product>> hits = searchResponse.hits().hits();
        for (Hit<Product> hit : hits) {
            Product product = hit.source();
            log.info("search page result: {}", product);
        }
    }


    public static void distanceQuery(ElasticsearchClient esClient, String indexName, GeoLocation centerPoint, double distance) throws IOException {
        Query query = GeoDistanceQuery.of(q -> q.distance(distance + "").field("location").location(centerPoint))._toQuery();
        SearchResponse<Product> response = esClient.search(s -> s
                        .index(indexName)
                        .query(q -> q.bool(b -> b.filter(query))),
                Product.class);
        List<Product> list = new ArrayList<>();
        for (Hit<Product> hit : response.hits().hits()) {
            list.add(hit.source());
        }
        log.info("distance query result: {}", list);
    }


    /**
     * {
     *   "query": {
     *     "bool": {
     *       "must": {
     *         "match_all": {}
     *       },
     *       "filter": {
     *         "geo_shape": {
     *           "location": {
     *             "shape": {
     *               "type": "polygon",
     *               "coordinates": [[[113.942373, 22.531399], [113.955111, 22.531432], [113.953261, 22.524538], [113.940451, 22.525991]]]
     *             },
     *             "relation": "within"
     *           }
     *         }
     *       }
     *     }
     *   }
     * }
     */
    public static void polygonQuery(ElasticsearchClient esClient, String indexName, List<List<Double>> points, GeoLocation sortPoint, int size) throws IOException {
        List<List<List<Double>>> coordinates = new ArrayList<>();
        coordinates.add(points);
        Map<String, Object> map = new HashMap<>(3);
        map.put("type", "polygon");
        map.put("relation", GeoShapeRelation.Within);
        map.put("coordinates", coordinates);
        Query geoShapeQuery = GeoShapeQuery.of(b -> b
                        .field("location")
                        .shape(s -> s
                                .shape(JsonData.of(map))))
                ._toQuery();
        SearchRequest.Builder builder = new SearchRequest.Builder();
        builder.index(indexName);
        builder.query(b -> b.bool(c -> c.filter(geoShapeQuery)));
        builder.size(size);
        if (sortPoint != null) {
            SortOptions sortOptions = SortOptions.of(s -> s
                    .geoDistance(v -> v
                            .field("location")
                            .location(sortPoint)
                            .unit(DistanceUnit.Meters)
                            .order(SortOrder.Asc)));
            builder.sort(sortOptions);
        }
        SearchResponse<Product> searchResponse = esClient.search(SearchRequest.of(s -> builder), Product.class);
        List<Product> list = new ArrayList<>();
        for (Hit<Product> hit : searchResponse.hits().hits()) {
            list.add(hit.source());
        }
        log.info("polygon search result: {}", list);
    }


    /**
     * {
     *   "query": {
     *     "bool": {
     *       "must": {
     *         "match_all": {}
     *       },
     *       "filter": {
     *         "geo_shape": {
     *           "polygon": {
     *             "shape": {
     *               "type": "point",
     *               "coordinates": [113.947305, 22.530055]
     *             },
     *             "relation": "contains"
     *           }
     *         }
     *       }
     *     }
     *   }
     * }
     */
    public static void polygonQuery(ElasticsearchClient esClient, String indexName, double x, double y, int size) throws IOException {
        Map<String, Object> map = new HashMap<>(3);
        map.put("type", "point");
        map.put("relation", GeoShapeRelation.Contains);
        map.put("coordinates", List.of(x, y));
        Query geoShapeQuery = GeoShapeQuery.of(b -> b
                        .field("polygon")
                        .shape(s -> s
                                .shape(JsonData.of(map))))
                ._toQuery();
        SearchResponse<Product> searchResponse = esClient.search(s -> s
                        .index(indexName)
                        .size(size)
                        .query(q -> q
                                .bool(b -> b
                                        .filter(geoShapeQuery))),
                Product.class);
        List<Product> list = new ArrayList<>();
        for (Hit<Product> hit : searchResponse.hits().hits()) {
            list.add(hit.source());
        }
        log.info("polygon search result: {}", list);
    }


}

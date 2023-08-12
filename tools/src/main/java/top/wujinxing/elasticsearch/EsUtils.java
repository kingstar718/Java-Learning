package top.wujinxing.elasticsearch;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;

import java.io.IOException;
import java.util.UUID;

/**
 * @author kingstar718
 * @date 2023-08-12
 */
@Slf4j
public class EsUtils {

    public static RestHighLevelClient buildHttpClient(String host, Integer port) {
        return new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, "http")));
    }


    public static void createIndex(RestHighLevelClient client, String indexName) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        log.info("create es index response: {}", response.isAcknowledged());
    }


    public static void existIndex(RestHighLevelClient client, String indexName) throws IOException {
        GetIndexRequest request = new GetIndexRequest(indexName);
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        log.info("es index: {}, exists: {}", indexName, exists);
    }

    public static void deleteIndex(RestHighLevelClient client, String indexName) throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        log.info("es index: {}, delete: {}", indexName, response.isAcknowledged());
    }


    public static void addDoc(RestHighLevelClient client, String indexName, Object o) throws IOException {
        IndexRequest request = new IndexRequest(indexName);
        request.id(UUID.randomUUID().toString().replace("-", ""));
        request.timeout(TimeValue.timeValueSeconds(3));
        request.source(JSON.toJSONString(o), XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        log.info("add doc response status: {}", response.status());
        log.info("add doc response: {}", response);
    }

    public static void searchDocById(RestHighLevelClient client, String indexName, String id) throws IOException {
        GetRequest request = new GetRequest(indexName, id);
        // 不获取返回的_source的上下文
        //request.fetchSourceContext(new FetchSourceContext(false));
        //request.storedFields("_none");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        log.info("es get: {}", response.getSourceAsString());
    }

}

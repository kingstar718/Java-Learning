package top.wujinxing;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.GeoLocation;
import co.elastic.clients.elasticsearch._types.mapping.*;
import co.elastic.clients.elasticsearch.core.UpdateResponse;
import org.junit.Before;
import org.junit.Test;
import top.wujinxing.elasticsearch.EsUtils;
import top.wujinxing.elasticsearch.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kingstar718
 * @date 2023-08-12
 */
public class EsTest {

    private ElasticsearchClient esClient;
    private final String indexName = "products";

    @Before
    public void getEsClientTest() throws IOException {
        String url = "http://localhost:9200";
        esClient = EsUtils.getEsClient(url);
    }

    @Test
    public void createIndexTest() throws IOException {
        EsUtils.createIndex(esClient, indexName);
    }


    @Test
    public void getIndexTest() throws IOException {
        EsUtils.getIndex(esClient, indexName);
    }

    @Test
    public void delIndexTest() throws IOException {
        EsUtils.delIndex(esClient, indexName);
    }

    @Test
    public void updateMappingsTest() throws IOException {
        Map<String, Property> documentMap = new HashMap<>();
        documentMap.put("name", Property.of(p -> p.text(TextProperty.of(t -> t.index(true)))));
        documentMap.put("location", Property.of(p -> p.geoPoint(GeoPointProperty.of(g -> g.ignoreZValue(true)))));
        // index 设置为 true，才可以使用 search range 功能
        documentMap.put("age", Property.of(p -> p.integer(IntegerNumberProperty.of(i -> i.index(true)))));
        EsUtils.updateMappings(esClient, indexName, documentMap);
    }

    @Test
    public void addOneDocTest() throws IOException {
        Product product = new Product();
        product.setId("ebf9f542-4c22-4bbb-ac48-c57f0d90e600");
        product.setName("科技公园");
        product.setLocation("22.530113,113.95177");
        EsUtils.addOneDocument(esClient, indexName, product);
    }

    @Test
    public void batchAddDocTest() throws IOException {
        // batch add doc
        Product p1 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e601", "喜茶", "22.530122,113.947539", 1);
        Product p2 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e602", "平安银行", "22.530055,113.945805", 2);
        Product p3 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e603", "T酒店公寓", "22.530372,113.943595", 3);
        Product p4 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e604", "锦云阁", "22.530631,113.940828", 4);
        Product p5 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e605", "学林雅园", "22.530714,113.937747", 5);
        List<Product> products1 = List.of(p1, p2, p3, p4, p5);

        Product p6 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e606", "供电服务大厦", "22.530264,113.933642", 6);
        Product p7 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e607", "荔园大厦", "22.530264,113.933642", 7);
        Product p8 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e608", "怡苑阁", "22.530898,113.928324", 8);
        Product p9 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e609", "华日宾馆", "22.530898,113.928324", 9);
        Product p10 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e610", "鸿海大厦", "22.531916,113.922072", 10);
        List<Product> products2 = List.of(p6, p7, p8, p9, p10);

        EsUtils.batchAddDocument(esClient, indexName, products1);
        EsUtils.batchAddDocument(esClient, indexName, products2);
    }


    @Test
    public void updateDocTest() throws IOException {
        Product p4 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e604", "锦云阁ab", "22.530631,113.940828");
        EsUtils.updateDocument(esClient, indexName, p4);
    }

    @Test
    public void getDocTest() throws IOException {
        EsUtils.getDocument(esClient, indexName, "ebf9f542-4c22-4bbb-ac48-c57f0d90e604");
    }

    @Test
    public void searchDocTest() throws IOException {
        EsUtils.searchOne(esClient, indexName, "阁");
    }

    @Test
    public void searchPageTest() throws IOException {
        EsUtils.searchPage(esClient, indexName, "云");
    }

    @Test
    public void distanceQueryTest() throws IOException {
        GeoLocation point = GeoLocation.of(g -> g.coords(List.of(113.949012,22.530297)));
        EsUtils.distanceQuery(esClient, indexName, point, 400d);
    }

    @Test
    public void polygonQueryTest() throws IOException {
        // 面落点搜索
        List<List<Double>> polygonList = new ArrayList<>();
        polygonList.add(List.of(113.942373,22.531399));
        polygonList.add(List.of(113.955111,22.531432));
        polygonList.add(List.of(113.953261,22.524538));
        polygonList.add(List.of(113.940451,22.525991));
        EsUtils.polygonQuery(esClient, indexName, polygonList, null, 10);
        // 从西处点按距离从近到远排序
        GeoLocation geoLocation = GeoLocation.of(g -> g.coords(List.of(113.931971,22.528027)));
        EsUtils.polygonQuery(esClient, indexName, polygonList, geoLocation, 10);
    }


    @Test
    public void updateMappingPolygonTest() throws IOException {
        Map<String, Property> documentMap = new HashMap<>();
        // 新增polygon多边形区域
        documentMap.put("polygon", Property.of(p -> p.geoShape(GeoShapeProperty.of(g -> g.ignoreZValue(true)))));
        EsUtils.updateMappings(esClient, indexName, documentMap);
    }

    @Test
    public void addPolygonData() throws IOException {
        Product p1 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e601", "喜茶", "22.530122,113.947539", 1);
        Product p2 = new Product("ebf9f542-4c22-4bbb-ac48-c57f0d90e602", "平安银行", "22.530055,113.945805", 2);
        Map<String, String> xicha = Map.of("polygon", "POLYGON ((113.947305 22.530055, 113.947682 22.530047, 113.947718 22.529788, 113.947341 22.529842, 113.947305 22.530055)) ");
        Map<String, String> pinan = Map.of("polygon", "POLYGON ((113.945594 22.530184, 113.945994 22.530118, 113.945908 22.529901, 113.945571 22.529892, 113.945594 22.530184)) ");

        UpdateResponse<Product> updateResponse1 = esClient.update(u -> u.
                index(indexName)
                .id("ebf9f542-4c22-4bbb-ac48-c57f0d90e601")
                .doc(xicha), Product.class);
        UpdateResponse<Product> updateResponse2 = esClient.update(u -> u.
                index(indexName)
                .id("ebf9f542-4c22-4bbb-ac48-c57f0d90e602")
                .doc(pinan), Product.class);
        System.out.println(updateResponse1.result());
        System.out.println(updateResponse2.result());
    }

    @Test
    public void polygonQueryByPointTest() throws IOException {
        double x = 113.947305;
        double y = 22.530055;
        double x2 = 113.945859;
        double y2 = 22.529963;
        EsUtils.polygonQuery(esClient, indexName, x, y, 1);
        EsUtils.polygonQuery(esClient, indexName, x2, y2, 1);
    }

}

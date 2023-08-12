package top.wujinxing;


import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import top.wujinxing.elasticsearch.EsUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author kingstar718
 * @date 2023-08-12
 */
public class EsTest {

    @Test
    public void indexTest() throws IOException {
        RestHighLevelClient client = EsUtils.buildHttpClient("127.0.0.1", 9200);
        String indexName = "test_index";
        EsUtils.createIndex(client, indexName);
        EsUtils.existIndex(client, indexName);
        EsUtils.deleteIndex(client, indexName);
    }


    @Test
    public void addDocTest() throws IOException {
        RestHighLevelClient client = EsUtils.buildHttpClient("127.0.0.1", 9200);
        String indexName = "test_index";
        EsUtils.createIndex(client, indexName);
        Map<String, Object> map = new HashMap<>();
        map.put("id", System.currentTimeMillis());
        map.put("name", "李白");
        map.put("age", 18);
        EsUtils.addDoc(client, indexName, map);
    }

    @Test
    public void searchDocTest() throws IOException {
        RestHighLevelClient client = EsUtils.buildHttpClient("127.0.0.1", 9200);
        String indexName = "test_index";
        EsUtils.searchDocById(client, indexName, "8f48432537b04ec8b28050dbbf3f325d");
    }
}

package top.wujinxing.ch_2_basicjava.httpclient;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @author wujinxing
 * date 2019/4/24 16:17
 * description
 */
public class ch_1_start {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.google.com/search?hl=en&q=httpclient&btnG=Google+Search&aq=f&oq=");
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {

            }finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

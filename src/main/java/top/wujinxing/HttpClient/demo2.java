package top.wujinxing.HttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/6/10 14:18
 * description 官网demo
 */
public class demo2 {
    /**
     * GET请求
     * @throws IOException
     */
    @Test
    public void getTest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //HttpGet httpGet = new HttpGet("http://coolaf.com");
        HttpGet httpGet = new HttpGet("https://www.baidu.com/");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            //System.out.println(entity.toString());
            EntityUtils.consume(entity);
        }finally {
            response.close();
        }
    }

    @Test
    public void postTest() throws IOException {
        HttpPost httpPost = new HttpPost("http://targethost/login");    //地址有问题
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(httpPost);
        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity);
        }finally {
            response.close();
        }
    }

    @Test
    public void testAlmanac(){
        Almanac almanac = AlmanacUtil.getAlmanac();
        System.out.println(almanac.toString());
    }
}

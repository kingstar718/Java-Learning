package top.wujinxing.httpclient;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author wujinxing
 * date 2019/4/24 16:17
 * description
 */
@Slf4j
public class ch_1_start1 {

    public static void main(String[] args) {
       requestPhone(18819332400L);
    }

    public static void requestPhone(Long phoneNum) {
        String phoneUrl = "https://api.vvhan.com/api/phone?tel=";
        String url = phoneUrl + phoneNum;
        HttpGet httpGet = new HttpGet(url);
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpGet)) {
            HttpEntity httpEntity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            String responseStr = EntityUtils.toString(httpEntity);
            if (HttpStatus.SC_OK == statusCode) {
                log.info("请求成功, status: {}, entity: {}", statusCode, responseStr);
            } else {
                log.error("请求失败, url: {}, status: {}, content: {}", url, statusCode, responseStr);
            }
        } catch (Exception e) {
            log.error("request phone error: ", e);
        }
    }

}

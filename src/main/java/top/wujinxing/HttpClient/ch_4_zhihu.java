package top.wujinxing.HttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author wujinxing
 * date 2019 2019/6/10 16:36
 * description
 */
public class ch_4_zhihu {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://book.douban.com/review/best/");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String entityString = EntityUtils.toString(entity);
        Document doc = Jsoup.parse(entityString);
        //Document doc = Jsoup.connect("https://www.zhihu.com/hot").get();
        Elements s = doc.getElementsByClass("main review-item");
        for (Element e: s
             ) {
            String bookName = e.child(0).child(0).attr("title"); //书名
            String bookReviewAuthor = e.child(1).child(1).text();// 书评作者名
            String bookReviewName = e.child(2).child(0).child(0).text();//书评名
            String bookReviewContent = e.child(2).child(1).child(0).text();//书评简略
            System.out.println(e.child(2).child(3).child(0).text());
            System.out.println();
        }
    }
}

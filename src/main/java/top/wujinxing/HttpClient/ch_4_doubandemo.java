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
public class ch_4_doubandemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://book.douban.com/review/9593753/";
        getBookReview();
        /*for(int i=0; i<10; i++){
            Thread.sleep(1000);
            System.out.println(i);
        }*/
    }

    private static void getBookReview() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://book.douban.com/review/best/?start=180");
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
            String isUseful = e.child(2).child(3).child(0).text(); //认为评论有用人数
            String isUseless = e.child(2).child(3).child(1).text();  //认为评论无用人数
            //System.out.println(e.child(1).text());
            String[] reviewTime = e.child(1).text().split(" ");
            String reTime = reviewTime[1]+reviewTime[2];
            //System.out.println(reTime);
            //String reviewTime = e.child(1).child(3).text(); //评论时间
            String reviewId = e.attr("id");

            System.out.println(Integer.parseInt(reviewId));

            String reviewAddress = e.child(2).child(0).child(0).attr("href"); //书评地址

        }
        response.close();
    }

    private static String getReview(String url) throws IOException {
        //"https://book.douban.com/review/9593753/"
        Document doc = Jsoup.connect(url).get();
        //System.out.println(doc);
        Elements s = doc.getElementsByClass("review-content clearfix");
        //Element e = doc.getElementById("review-content");
        //System.out.println(e);
        String reviewContent = "";
        for (Element e:s
        ) {
            Elements e1 = e.getElementsByTag("p");
            reviewContent = e1.toString();
        }
        return reviewContent;
    }
}

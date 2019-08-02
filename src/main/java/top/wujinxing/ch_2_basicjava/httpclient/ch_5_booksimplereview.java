package top.wujinxing.ch_2_basicjava.httpclient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/6/25 15:21
 * description 爬取豆瓣简短书评
 */
public class ch_5_booksimplereview {

    @Test
    public void test() throws IOException{
        String url = "https://book.douban.com/subject/1770782/comments/hot?p=1";
        List<BookSimpleReview> list = getBookSimpleReview(url);
    }

    public static List<BookSimpleReview> getBookSimpleReview(String url) throws IOException{
        //String url = "https://book.douban.com/subject/1770782/comments/hot?p=1";
        Document doc = Jsoup.connect(url).get();
        //System.out.println(doc);
        Elements es = doc.getElementsByClass("comment-item");
        List<BookSimpleReview> list = new ArrayList<>();

        for(Element e: es){
            //thread.sleep(1000);
            BookSimpleReview bookSimpleReview = new BookSimpleReview();
            Integer usefulNum = Integer.parseInt(e.child(1).child(0).child(0).child(0).text());
            String content = e.child(1).child(1).child(0).text();
            String userAddress = e.child(1).child(0).child(1).child(0).attr("href");

            String nameAndTime = e.child(1).child(0).child(1).text();
            String[] nameAndTimeArray = nameAndTime.split(" ");
            String userName = nameAndTimeArray[0];
            String reviewTime = nameAndTimeArray[1];
            Integer reviewId = Integer.parseInt(e.attr("data-cid"));
            //System.out.println(reviewId);

            bookSimpleReview.setReviewId(reviewId);
            bookSimpleReview.setUserName(userName);
            bookSimpleReview.setContent(content);
            bookSimpleReview.setReviewTime(reviewTime);
            bookSimpleReview.setUserAddress(userAddress);
            bookSimpleReview.setUsefulNum(usefulNum);
            System.out.println(reviewId);
            list.add(bookSimpleReview);
        }
        return list;
    }
}

package top.wujinxing.HttpClient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author wujinxing
 * date 2019 2019/6/10 15:56
 * description Jsoup 解析库demo
 */
public class ch_3_jsoup {

    @Test
    public void test1() throws IOException {
        //1. 获取URL的标题
        Document doc = Jsoup.connect("https://www.yiibai.com").get();
        String title = doc.title(); //获取标题
        System.out.println(title);
        //2. 从html文件中获取属性
        //Document doc = Jsoup.parse(new File("e:\\register.html"),"utf-8");//assuming register.html file in e drive
        //String title = doc.title();

        //3. 获取URL的链接
        Elements links = doc.select("a[href]");
        for (Element e: links
             ) {
            System.out.println("\nlink: " + e.attr("href")+" and text: " + e.text());
        }

        //3. POST请求
        Document docPost = Jsoup.connect("http://example.com")
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();
        String s = docPost.toString();
        System.out.println(s);
    }

    /**
     * Extract attributes, text, and HTML from elements
     */
    @Test
    public void test2(){
        String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        Document doc = Jsoup.parse(html);
        Element link = doc.select("a").first();

        String text  = doc.body().text();
        String linkHref = link.attr("href");
        String linkText = link.text();
        String linkOuterH = link.outerHtml();
        String linkInnerH = link.html();
    }

}

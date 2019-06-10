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
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wujinxing
 * date 2019 2019/6/10 14:47
 * description 博客例子
 */
public class AlmanacUtil {

    /**
     * 单例工具类
     */
    private AlmanacUtil(){

    }

    /**
     * 获取万年历信息
     * @return Almanac类
     */
    public static Almanac getAlmanac(){
        String url = "http://tools.2345.com/rili.htm";
        String s = getPage(url);
        //System.out.println(s);
        Almanac almanac = analyzeHTML(s);
        return almanac;
    }

    private static String getPage(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpGet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                //获取响应实体
                HttpEntity entity = response.getEntity();
                if (entity!=null){
                    return EntityUtils.toString(entity);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static Almanac analyzeHTML(String html){
        String solarDate,lunarDate,chineseAra,should,avoid=" ";
        Document document = Jsoup.parse(html);
        //公历时间
        solarDate = getSolarDate();
        //农历时间
        Element eLunarDate = document.getElementById("info_nong");
        lunarDate = eLunarDate.child(0).html().substring(1,3)+eLunarDate.html().substring(11);
        //天干地支纪年法
        Element eChineseAra = document.getElementById("info_chang");
        chineseAra = eChineseAra.text().toString();
        //宜
        should = getSuggestion(document, "yi");
        //忌
        avoid = getSuggestion(document, "ji");
        Almanac almanac = new Almanac(solarDate, lunarDate, chineseAra, should, avoid);
        return almanac;
    }

    @Test
    public void test(){
        String url = "http://tools.2345.com/rili.htm";
        String s = getPage(url);
        //System.out.println(s);
        Almanac almanac = analyzeHTML(s);
        System.out.println(almanac.toString());
    }

    /**
     * 获取忌/宜
     * @param doc
     * @param id
     * @return
     */
    private static String getSuggestion(Document doc, String id){
        Element element = doc.getElementById(id);
        Elements elements = element.getElementsByTag("a");
        StringBuffer sb = new StringBuffer();
        for (Element e: elements
             ) {
            sb.append(e.text()+" ");
        }
        return sb.toString();
    }

    /**
     * 获取公历时间,用yyyy年MM月dd日 EEEE格式表示。
     * @return  yyyy年MM月dd日 EEEE
     */
    private static String getSolarDate(){
        Calendar calendar = Calendar.getInstance();
        Date solarDate = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 EEEE");
        return format.format(solarDate);
    }
}

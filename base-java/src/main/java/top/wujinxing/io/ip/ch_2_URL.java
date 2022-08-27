package top.wujinxing.io.ip;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author wujinxing
 * date 2019 2019/9/25 15:10
 * description url类的使用
 */
public class ch_2_URL {

    public static void main(String[] args) {
        URL myURL = null;
        try {
            myURL = new URL("https://www.weixueyuan.net:80");
            System.out.println(myURL.getHost());
        } catch (MalformedURLException e) {
            System.out.println("URL error" + myURL + e);
        }
    }
}

package top.wujinxing.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author wujinxing
 * @date 2019/4/25 09:59
 * @description
 */
public class NetDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");

        InputStream is = url.openStream();

        InputStreamReader isr = new InputStreamReader(is, "utf-8");

        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }
}

package top.wujinxing.ch_2_basicjava.httpclient;

import org.pegdown.PegDownProcessor;

import java.io.*;

/**
 * @author wujinxing
 * date 2019 2019/11/27 20:37
 * description
 */
public class mdTest {

    public static void main(String[] args) throws IOException {
        File mdFile = new File("F:\\Books\\Blog\\docs\\English\\word1.md");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(mdFile), "UTF-8"));
        String line = null;
        String mdContent = "";
        while ((line = br.readLine()) != null){
            mdContent += line + "\r\n";
        }
        PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
        String htmlContent = pdp.markdownToHtml(mdContent);
        System.out.println(htmlContent);
    }

}

package top.wujinxing.ch_2_basicjava.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/1/21 21:16
 * @description:
 */
public class FileDemo2 {
    public static void main(String[] args){
        //写入并读取文件
        Path textFile = Paths.get("f:/FileDemo/top/wujinxing/demo.txt");
        Charset charset = Charset.forName("US-ASCII");
        String line1 = "Easy read and write";
        String line2 = "with java.nio.file.Files";
        List<String> lines = Arrays.asList(line1,line2);
        System.out.println(lines);
        //写入
        try {
            Files.write(textFile, lines, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取
        List<String> linesRead = null;
        try {
            linesRead = Files.readAllLines(textFile,charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (linesRead != null){
            for (String line: linesRead
                 ) {
                System.out.println(line);
            }
        }
    }

}

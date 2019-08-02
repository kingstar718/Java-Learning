package top.wujinxing.ch_2_basicjava.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author wujinxing
 * @date 2019/4/25 09:41
 * @description
 */
public class FileDemo4 {
    public static void main(String[] args) throws IOException {
        String src = "F:\\AWorkSpace\\data\\test.txt";
        readFileContent(src);
    }

    public static void readFileContent(String filePath) throws IOException{
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
    }
}

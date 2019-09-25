package top.wujinxing.ch_2_basicjava.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujinxing
 * date 2019/1/21 21:16
 * description 读取文件内容
 */
public class ch_2_readFile {

    public static final String READ_TEST = "D:\\Git\\Java-Learning\\src\\main\\java\\top\\wujinxing\\ch_2_basicjava\\io\\readTest.txt";
    public static final String WRITER_TEST = "D:\\Git\\Java-Learning\\src\\main\\java\\top\\wujinxing\\ch_2_basicjava\\io\\writerTest.txt";


    /**
     * 利用FileRead读取文件内容
     * @throws IOException IO
     */
    @Test
    public void readFile() throws IOException {
        char[] c = new char[1000];
        FileReader fileReader = new FileReader(READ_TEST);
        int num = fileReader.read(c);
        String s = new String(c, 0, num);
        System.out.println("读取的字符个数为：" + num + " 内容为：");
        System.out.println(s);
        //需要注意的是，Java 把一个汉字或英文字母作为一个字符对待，回车或换行作为两个字符对待
    }

    /**
     * 利用缓冲区读取文件
     */
    @Test
    public void buffRead(){
        String OneLine;
        int count = 0;
        try {
            FileReader fileReader = new FileReader(READ_TEST);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((OneLine = bufferedReader.readLine())!=null){
                count++;
                System.out.println(OneLine);
            }
            System.out.println("共读取了：" + count + " 行。");
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void fileWriter(){
        try {
            FileWriter fileWriter = new FileWriter(WRITER_TEST);
            for (int i=32; i<126; i++){
                fileWriter.write(i);//将ASCII字符写入到文件中 也是清空文件内容后重新写入的
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓冲区读写
     */
    @Test
    public void bufferWriter(){
        String str;
        try {
            BufferedReader in = new BufferedReader(new FileReader(READ_TEST));
            BufferedWriter out = new BufferedWriter(new FileWriter(WRITER_TEST));
            while ((str=in.readLine())!=null){
                System.out.println(str);
                out.write(str); //该方法似乎是清空了文件内容后重新写入的
                out.newLine();//写入换行符
            }
            out.flush();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void readFile2(){
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

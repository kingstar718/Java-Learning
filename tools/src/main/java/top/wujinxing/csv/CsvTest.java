package top.wujinxing.csv;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author wujinxing
 * @date 2020-10-09
 */
public class CsvTest {

    @Test
    public void csvRead() {
        String readerPath = "reader.csv";
        String path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(readerPath)).getPath();
        try {
            //创建csv读对象
            CsvReader reader = new CsvReader(path, ',', StandardCharsets.UTF_8);
            //读表头
            if (reader.readHeaders()){
                String[] headers = reader.getHeaders();
                System.out.println(Arrays.toString(headers));
            }
            while (reader.readRecord()) {
                //读一整行
                System.out.println(reader.getRawRecord());
                //读这一行的某一列
                System.out.println(reader.get("姓名"));
            }
        } catch (IOException e) {
            System.out.println("读取错误：" + e);
        }
    }

    @Test
    public void csvWrite() {
        String writerPath = "writer.csv";
        String path = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(writerPath)).getPath();
        try {
            //文件可以不存在
            CsvWriter writer = new CsvWriter(path, ',', Charset.forName("GBK"));
            //写表头
            String[] headers = {"编号", "姓名", "年龄"};
            String[] content = {"12365", "张山", "34"};
            writer.writeRecord(headers);
            writer.writeRecord(content);
            //关闭，关闭才能写完
            writer.close();
        } catch (IOException e) {
            System.out.println("写入错误：" + e);
        }
    }

}

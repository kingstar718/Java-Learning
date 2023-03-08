package top.wujinxing.java11;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wujinxing
 * @date 2023/3/8
 */
public class Ch7InputStream {

    public static void main(String[] args) throws IOException {
        var classLoader = ClassLoader.getSystemClassLoader();
        var inputStream = classLoader.getResourceAsStream("test.txt");
        var tempFile = File.createTempFile("java stack 2", "txt");
        try (var outputStream = new FileOutputStream(tempFile)){
            // 将数据直接传输到OutputStream
            inputStream.transferTo(outputStream);
        }
    }

}

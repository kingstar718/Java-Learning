package top.wujinxing.java11;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author wujinxing
 * @date 2022-09-23
 */
@Slf4j
public class Ch4FileApi {

    public static void main(String[] args) throws IOException {
        // 创建临时文件
        Path tempFile = Files.createTempFile("test", "txt");
        Files.writeString(tempFile, "hello world");

        // 读取文件
        var path = Thread.currentThread().getContextClassLoader().getResource("test.txt").getPath();
        var content = Files.readString(Path.of(path));
        log.info("content:{}", content);
    }

}

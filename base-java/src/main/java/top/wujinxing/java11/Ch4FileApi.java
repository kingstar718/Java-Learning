package top.wujinxing.java11;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

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
        // 有时会多一个/，导致读取失败，判断第一个是否为/，如果是，则去掉
        if (StringUtils.startsWith(path, "/")) {
            path = path.substring(1);
        }
        var content = Files.readString(Path.of(path));
        log.info("content:{}", content);
    }

}

package top.wujinxing.ch_2_basicjava.io;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author wujinxing
 * date 2019/1/21 16:38
 * description 文件与目录的创建与删除
 */
public class ch_1_createDeleteFile {

    @Test
    public void testFile() {
        //获取当前目录的文件系统
        Path path = Paths.get("D:\\Git\\Java-Learning\\src\\main\\java\\top\\wujinxing\\ch_2_basicjava\\io");
        System.out.println(path.getNameCount());
        System.out.println(path.getName(1));
        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.getRoot());
    }

    @Test
    public void createAndDelete() {
        String filePath = "D:\\Git\\Java-Learning\\src\\main\\java\\top\\wujinxing\\ch_2_basicjava\\io\\test.txt";
        String direPath = "D:\\Git\\Java-Learning\\src\\main\\java\\top\\wujinxing\\ch_2_basicjava\\io\\test";
        //创建、删除文件与目录
        try {
            if (Files.exists(Paths.get(filePath))) {
                System.out.println("文件已存在");
            } else {
                Files.createFile(Paths.get(filePath));
                System.out.println("创建文件成功！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (Files.exists(Paths.get(direPath))) {
                System.out.println("目录已存在！");
            } else {
                Files.createDirectory(Paths.get(direPath));
                System.out.println("创建目录成功！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.deleteIfExists(Paths.get(filePath)); //判断是否存在并删除
            System.out.println("file existed and will be deleted");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

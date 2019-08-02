package top.wujinxing.ch_2_basicjava.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: wujinxing
 * @date: 2019/1/21 16:38
 * @description:
 */
public class FileDemo {
    public static void main(String[] args) {
        //获取当前的文件系统
        Path path1 = Paths.get("f:/FileDemo/top/wujinxing");
        System.out.println(path1.getNameCount());
        System.out.println(path1.getName(1));
        System.out.println(path1.getFileName());
        System.out.println(path1.getParent());
        System.out.println(path1.getRoot());
        //创建、删除文件与目录
        try {
            Files.createFile(Paths.get("f:/FileDemo/top/wujinxing/jaj.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建文件夹
        /*try {
            Files.createDirectory(Paths.get("f:/FileDemo/top/sasas1"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            if (Files.deleteIfExists(Paths.get("f:/FileDemo/top/wujinxing1"))){
                Files.delete(Paths.get("f:/FileDemo/top/wujinxing1"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

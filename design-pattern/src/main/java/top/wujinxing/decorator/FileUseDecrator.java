package top.wujinxing.decorator;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * @author: wujinxing
 * @date: 2019/3/25 17:43
 * @description: 以OutputStream为核心的装饰者模式的实现
 */
public class FileUseDecrator {
    public static void main(String[] args) throws Exception {
        //生成一个有缓冲功能的流对象
        DataOutputStream dout =
                new DataOutputStream(new BufferedOutputStream(
                        new FileOutputStream("test.txt")
                ));
        //没有缓冲功能的流对象
        DataOutputStream doutn =
                new DataOutputStream(
                        new FileOutputStream("test2.txt")
                );
        long begin  = System.currentTimeMillis();
        for (int i=0; i<100000; i++)
            dout.write(i);
        System.out.println("Spend : " + (System.currentTimeMillis()-begin));

        begin  = System.currentTimeMillis();
        for (int i=0; i<100000; i++)
            doutn.write(i);
        System.out.println("Spend : " + (System.currentTimeMillis()-begin));

        //有缓冲区的拥有更好的I/O性能
    }
}

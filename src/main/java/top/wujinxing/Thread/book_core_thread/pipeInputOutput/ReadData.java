package top.wujinxing.Thread.book_core_thread.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author: wujinxing
 * @date: 2019/3/1 15:33
 * @description:
 */
public class ReadData {
    public void readMethod(PipedInputStream input) {//new一个管道输入对象
        try {
            System.out.println("read  :");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = input.read(byteArray);//输入读入数据
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

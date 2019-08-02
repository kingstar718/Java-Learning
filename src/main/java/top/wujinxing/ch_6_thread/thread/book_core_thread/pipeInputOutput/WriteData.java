package top.wujinxing.ch_6_thread.thread.book_core_thread.pipeInputOutput;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author: wujinxing
 * @date: 2019/3/1 15:32
 * @description:
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());//数据写入
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

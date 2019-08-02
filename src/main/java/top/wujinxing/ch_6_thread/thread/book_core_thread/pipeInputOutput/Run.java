package top.wujinxing.ch_6_thread.thread.book_core_thread.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author: wujinxing
 * @date: 2019/3/1 15:35
 * @description:
 */
public class Run {
    public static void main(String[] args) {

        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            //使两个管道之间产生通信链接，这样才可以进行数据输入与输出
            // inputStream.connect(outputStream);
            outputStream.connect(inputStream);

            //读取线程先执行，由于没有数据写入，线程停在int readLength = input.read(byteArray);
            ThreadRead threadRead = new ThreadRead(readData, inputStream);
            threadRead.start();

            Thread.sleep(2000);

            //写入线程启动，outputStream写入数据，由connect，inputStream也有数据了，读取线程启动，读取输入
            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            threadWrite.start();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

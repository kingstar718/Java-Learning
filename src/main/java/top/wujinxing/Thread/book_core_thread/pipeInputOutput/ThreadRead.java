package top.wujinxing.Thread.book_core_thread.pipeInputOutput;

import java.io.PipedInputStream;

/**
 * @author: wujinxing
 * @date: 2019/3/1 15:33
 * @description:    读取线程
 */
public class ThreadRead extends Thread{
    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        super();
        this.read = read;
        this.input = input;
    }

    /**
     * 将input数据读入read
     */
    @Override
    public void run() {
        read.readMethod(input);
    }
}

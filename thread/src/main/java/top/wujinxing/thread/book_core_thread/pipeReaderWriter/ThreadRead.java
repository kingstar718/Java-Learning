package top.wujinxing.thread.book_core_thread.pipeReaderWriter;

import java.io.PipedReader;

/**
 * @author: wujinxing
 * @date: 2019/3/1 16:09
 * @description:
 */
public class ThreadRead extends Thread {
    private ReadData read;
    private PipedReader input;

    public ThreadRead(ReadData read, PipedReader input) {
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}

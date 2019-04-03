package top.wujinxing.Thread.book_core_thread.pipeReaderWriter;

import java.io.PipedWriter;

/**
 * @author: wujinxing
 * @date: 2019/3/1 16:09
 * @description:
 */
public class ThreadWrite extends Thread {

    private WriteData write;
    private PipedWriter out;

    public ThreadWrite(WriteData write, PipedWriter out) {
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}

package top.wujinxing.Thread.book_core_thread.pipeInputOutput;

import java.io.PipedOutputStream;

/**
 * @author: wujinxing
 * @date: 2019/3/1 15:34
 * @description:    写入线程
 */
public class ThreadWrite extends Thread{
    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        super();
        this.write = write;
        this.out = out;
    }

    /**
     * 将out数据写入write
     */
    @Override
    public void run() {
        write.writeMethod(out);
    }
}

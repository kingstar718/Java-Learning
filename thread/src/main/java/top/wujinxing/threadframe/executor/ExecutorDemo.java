package top.wujinxing.threadframe.executor;

import top.wujinxing.threadframe.threadpool.MyThread;

import java.util.concurrent.*;

/**
 * @author wujinxing
 * @date 2019/3/27 10:18
 */
public class ExecutorDemo {

    public static void main(String[] args) {
        //得到一个可复用的线程池
        ExecutorService exe = Executors.newCachedThreadPool();

        long begin = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            exe.execute(new MyThread("testJDKThreadPool" + Integer.toString(i)));
        }
        System.out.println(System.currentTimeMillis() - begin);

        //MyThread2 优先队列
        ExecutorService exe2 = new ThreadPoolExecutor(100, 200,
                0L, TimeUnit.SECONDS, new PriorityBlockingQueue<>());

        for (int i = 0; i < 1000; i++) {
            exe2.execute(new MyThread2("testThreadPoolExecutor3_" + (999 - i)));
        }
    }
}

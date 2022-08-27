package top.wujinxing.thread.threadpool;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: wujinxing
 * @date: 2019/3/7 10:15
 * @description:
 */
public class Test1_threadpool {

    /**
     * 使用线程池
     */
    @Test
    public void useThreadPool(){
        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<>();
        ThreadPoolExecutor tp = new ThreadPoolExecutor(100,100,60,TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(20000));
        final Random random = new Random();
        for (int i = 0; i < 20000; i++){
            tp.execute(new Runnable() {
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            });
        }
        tp.shutdown();
        try {
            tp.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());
    }

    @Test
    public void noThreadPool(){
        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<>();
        final Random random = new Random();
        for (int i = 0; i < 20000; i++){
            Thread thread = new Thread(){
                @Override
                public void interrupt() {
                    l.add(random.nextInt());
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());
    }
}

package top.wujinxing.ch_6_thread.review;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wujinxing
 * date 2019 2019/8/15 15:21
 * description 四种线程池
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //newCachedThreadPoolTest();
        //newFixedThreadPoolTest();
        //newScheduledThreadPoolTest();
        newSingleThreadExecutorTest();
    }

    /**
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
     */
    private static void newCachedThreadPoolTest(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i=0; i<10; i++){
            final int index = i;
            try {
                Thread.sleep(index*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("index: " + index);
                }
            });
        }
    }

    /**
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     * 注意test时，主线程的运行时间加大，如Thread.sleep(100000); 因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
     * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()。可参考PreloadDataCache。
     */
    private static void newFixedThreadPoolTest(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i=0; i<10; i++){
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("index:" + index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    /**
     * 创建一个定长线程池，支持定时及周期性任务执行。
     */
    private static void newScheduledThreadPoolTest(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        //表示延迟3秒执行
        /*scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 1 seconds");
            }
        }, 3, TimeUnit.SECONDS);*/

        //表示延迟1秒后每3秒执行一次
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);

    }

    /**
     *创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     * 结果依次输出，相当于顺序执行各个任务。
     */
    private static void newSingleThreadExecutorTest(){
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i=0; i<10; i++){
            final int index = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

package top.wujinxing.ch_6_thread.thread.threadpool;


import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import java.util.concurrent.*;

/**
 * @author wujinxing
 * @date 2022-04-20
 */
public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors() * 5,
                Runtime.getRuntime().availableProcessors() * 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(8192),
                new BasicThreadFactory.Builder().namingPattern("my-thread-pool-%d").daemon(true).build());
        //executor.submit(() -> System.out.println("thread name: " +Thread.currentThread().getName() ));

        //List<Task> list = Arrays.asList(new Task(1), new Task(2), new Task(3), new Task(0));
        //list.forEach(executor::submit);

        for (int i=3; i>-2; i--) {
            executor.submit(new Task(i));
        }

        //executor.shutdown();
        //executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);

        System.out.println(1);
        System.out.println(Thread.currentThread().getName());
    }

    static class Task implements Runnable {

        private Integer i;

        public Task(Integer i) {
            System.out.println("task init: i=" + i + ", thread: " + Thread.currentThread().getName());
            this.i = i;
        }

        @Override
        public void run() {
            try {
                int m = 5/i;
                System.out.println(Thread.currentThread().getName() + ": " +m);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

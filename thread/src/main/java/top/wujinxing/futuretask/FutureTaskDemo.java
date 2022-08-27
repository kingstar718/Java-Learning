package top.wujinxing.futuretask;

import java.util.concurrent.*;

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executors = Executors.newCachedThreadPool();

        long start = System.currentTimeMillis();

        // 等凉菜
        Callable<String> c1 = () -> {
            Thread.sleep(1000);
            return "等凉菜";
        };
        FutureTask<String> ft1 = new FutureTask<>(c1);
        // new Thread(ft1).start();

        // 等凉菜
        Callable<String> c2 = () -> {
            Thread.sleep(3000);
            return "等包子";
        };
        FutureTask<String> ft2 = new FutureTask<>(c2);
        // new Thread(ft2).start();

        executors.submit(ft1);
        executors.submit(ft2);
        executors.shutdown();

        System.out.println(ft1.get());
        System.out.println(ft2.get());

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

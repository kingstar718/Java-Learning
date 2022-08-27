package top.wujinxing.review;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wujinxing
 * date 2019/9/27 16:44
 * description Callable
 */
public class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 123;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo cd = new CallableDemo();
        FutureTask<Integer> ft = new FutureTask<>(cd);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}

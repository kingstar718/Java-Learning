package top.wujinxing.ch_2_basicjava.callback;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wujinxing
 * date 2019 2019/9/7 14:50
 * description 多线程中的“回调”
 *
 * Java多线程中可以通过callable和future或futuretask结合来获取线程执行后的返回值。
 * 实现方法是通过get方法来调用callable的call方法获取返回值。
 *
 * 其实这种方法本质上不是回调，回调要求的是任务完成以后被调用者主动回调调用者的接口。
 * 而这里是调用者主动使用get方法阻塞获取返回值。
 */
public class ThreadCallBack {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call");
                TimeUnit.SECONDS.sleep(1);
                return "str";
            }
        });
        //手动阻塞调用get通过call方法获得返回值。
        System.out.println(future.get());
        //需要手动关闭，不然线程池的线程会继续执行。
        executor.shutdown();

        //使用futuretask同时作为线程执行单元和数据请求单元。
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("dasds");
                return new Random().nextInt();
            }
        });

        new Thread(futureTask).start();
        //阻塞获取返回值
        System.out.println(futureTask.get());

    }
    @Test
    public void test(){
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };

        FutureTask futureTask = new FutureTask(callable);
    }
}

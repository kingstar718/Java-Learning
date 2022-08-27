package top.wujinxing.completefuture;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author wujinxing
 */
@Slf4j
public class Ch1CompletableFutureTest {

    private final ExecutorService executor = Executors.newFixedThreadPool(5);


    /**
     * 使用FutureTask来执行任务
     * FutureTask#get()本身是阻塞的；无法对任务进行编排
     * 即使和下面的例子一样，结合轮询+isDone()，但仍然有问题：
     * 1、轮询时间间隔
     * 2、为了避免while(true)阻塞主线程，可能需要开启单独的线程进行轮询，浪费一个线程
     * 3、仍然无法处理复杂的任务依赖关系
     *
     * @throws InterruptedException /
     * @throws ExecutionException   /
     */
    @Test
    public void testFutureAsk() throws InterruptedException, ExecutionException {

        // 任务1
        Future<String> runnableFuture = executor.submit(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                log.info("Runnable 异步线程开始...");
                TimeUnit.SECONDS.sleep(3);
                log.info("Runnable 异步线程开结束..");
            }
        }, "fakeRunnableResult");

        //任务2
        Future<String> callableFuture = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("Callable 异步线程开始...");
                TimeUnit.SECONDS.sleep(3);
                log.info("Runnable 异步线程开始...");
                return "callableResult";
            }
        });

        boolean runnableDone = false;
        boolean callableDone = false;

        // 不断轮训直到所有任务结束
        do {
            TimeUnit.MICROSECONDS.sleep(500);
            log.info("轮训异步结果...");
            if (runnableFuture.isDone()) {
                log.info("Runnable执行结果：" + runnableFuture.get());
                runnableDone = true;
            }
            if (callableFuture.isDone()) {
                log.info("Callable执行结果：" + callableFuture.get());
                callableDone = true;
            }
        } while (!callableDone || !runnableDone);

        log.info("任务全部结束");
    }
}

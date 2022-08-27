package top.wujinxing.completefuture;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @author wujinxing
 */
@Slf4j
public class Ch3CompletableFutureTest {

    /**
     * CompletableFuture实现了CompletionStage接口的方法并设计出了异步回调的机制
     *
     * 1、异步线程来自ForkJoinPool线程池
     * 2、通过CompletableFuture#supplyAsync(supplier)传入Supplier，返回CompletableFuture对象，它包含一个来自未来的value，且这个value会在稍后由异步线程执行Supplier#get()产生
     * 3、异步线程会执行AsyncSupple#run()并在方法内调用f.get()，也就是Supplier#get()，阻塞获取结果并通过d.completeValue(v)将值设置到CompletableFuture中
     * 4、CompletableFuture已经在上一步的asyncSuppleStage()中被返回，最终效果和线程池+FutureTask是一样的，先返回Future实例，在通过引用把值放进去
     *
     * 如何实现异步回调呢：CompletableFuture的回调机制本质上是对多个CompletableFuture内部函数的顺序执行，只不过发起者是异步线程而不是主线程
     *
     * @throws InterruptedException /
     */
    @Test
    public void testCallBack() throws InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                log.info("--->异步线程开始...");
                log.info("--->异步线程为：{}", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(10);
                log.info("--->异步线程结束...");
                return "supplierResult";
            }
        });

        // 异步回调，上面的Supplier#get()返回结果后，异步线程会回调BiConsumer#accept()
        completableFuture.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                log.info("--->异步任务结束回调...");
                log.info("--->回调线程为：{}", Thread.currentThread().getName());
            }
        });

        // CompletableFuture的异步线程是守护线程，一旦main结束就没了，为了看到打印结果，需要让main休眠一会
        log.info("main结束");
        TimeUnit.SECONDS.sleep(15);
    }
}

package top.wujinxing.completefuture;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author wujinxing
 */
@Slf4j
public class Ch4CompletableFutureTest {

    @Test
    public void testCallBack() throws InterruptedException {

        //任务1、将第一个任务推进去，顺便开启异步线程
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                log.info("异步线程开始...");
                TimeUnit.SECONDS.sleep(10);
                log.info("--->completableFuture1任务结束");
                log.info("--->执行completableFuture1的线程为：{}", Thread.currentThread().getName());
                return "supplierResult";
            }
        });
        log.info("completableFuture1: {}", completableFuture1);

        //任务2、将第二个任务推进去，等待异步回调
        CompletableFuture<String> completableFuture2 = completableFuture1.thenApply(new Function<String, String>() {
            @SneakyThrows
            @Override
            public String apply(String s) {
                log.info("异步线程开始...");
                TimeUnit.SECONDS.sleep(10);
                log.info("--->completableFuture2任务结束, result={}", s);
                log.info("--->执行completableFuture2的线程为：{}", Thread.currentThread().getName());
                return s;
            }
        });
        log.info("completableFuture2: {}", completableFuture2);

        //任务3、将第三个任务推进去，等待异步回调
        CompletableFuture<String> completableFuture3 = completableFuture2.thenApply(new Function<String, String>() {
            @SneakyThrows
            @Override
            public String apply(String s) {
                log.info("异步线程开始...");
                TimeUnit.SECONDS.sleep(10);
                log.info("--->completableFuture3任务结束, result={}", s);
                log.info("--->执行completableFuture3的线程为：{}", Thread.currentThread().getName());
                return s;
            }
        });
        log.info("completableFuture3: {}", completableFuture3);

        log.info("主线程结束");
        TimeUnit.SECONDS.sleep(40);
    }
}

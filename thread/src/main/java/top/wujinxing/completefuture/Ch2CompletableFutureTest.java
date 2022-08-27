package top.wujinxing.completefuture;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author wujinxing
 *
 * 基于异步回调的Future
 */
@Slf4j
public class Ch2CompletableFutureTest {

    @Test
    public void testCallBack() throws ExecutionException, InterruptedException {
        // 提交一个任务，返回CompleteFuture
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                log.info("===>异步线程开始...");
                log.info("===>异步线程：" + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    log.error("interruptedException: ", e);
                }
                log.info("===>异步线程结束...");
                return "supplierResult";
            }
        });

        // 阻塞获取结果，一般不推荐这样使用
        log.info("异步结果是：{}", completableFuture.get());
        log.info("test结束");
    }
}

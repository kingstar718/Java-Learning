package top.wujinxing.completefuture;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author 01397208
 * @date 2024/1/25
 */
@Slf4j
public class Ch5CompletableFutureTest {

    private static void run(long second) {
        try {
            TimeUnit.SECONDS.sleep(second);
            log.info("thread: {}, second: {}", Thread.currentThread().getName(), second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void allTest() throws InterruptedException{
        long start = System.currentTimeMillis();
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> run(1));
        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> run(2));
        CompletableFuture<Void> f3 = CompletableFuture.runAsync(() -> run(3));
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(f1, f2, f3);

        try {
            completableFuture.get(3020, TimeUnit.MILLISECONDS);
            if (completableFuture.isCompletedExceptionally()) {
                Void v1 = f1.get();
                Void v2 = f2.get();
                Void v3 = f3.get();
            }
            log.info("all end, cost time: {}", System.currentTimeMillis() - start);
        } catch (ExecutionException | TimeoutException e) {
            log.error("all test failed, error: ", e);
        }

    }

}

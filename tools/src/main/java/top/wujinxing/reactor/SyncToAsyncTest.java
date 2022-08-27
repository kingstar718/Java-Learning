package top.wujinxing.reactor;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author kingstar718
 * @date 2022-08-07
 */
@Slf4j
public class SyncToAsyncTest {

    private static final Random rand;

    static {
        try {
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSyncToAsync() throws InterruptedException {
        // 前面介绍到Schedulers.elastic()能够方便地给一个阻塞的任务分配专门的线程，从而不会妨碍其他任务和资源。
        // 我们就可以利用这一点将一个同步阻塞的调用调度到一个自己的线程中，并利用订阅机制，待调用结束后异步返回。
        // 这里有个疑问：如果是http-nio线程，将任务赋给专门的线程，那这个nio线程是什么状态呢？
        // 会重新分发给其他接入的请求吗？最后又怎么拿回这个值呢
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Mono.fromCallable(this::getStringSync)
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(s -> log.info("subscribe: {}", s), null, countDownLatch::countDown);
        countDownLatch.await(10, TimeUnit.SECONDS);
    }

    @Test
    public void paraAsync() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread thread1 = new Thread(() -> {
            Mono.fromCallable(this::random)
                    .subscribeOn(Schedulers.boundedElastic())
                    .subscribe(s -> log.info("thread 1: {}", s), null, countDownLatch::countDown);
        });
        Thread thread2 = new Thread(() -> {
            Mono.fromCallable(this::random)
                    .subscribeOn(Schedulers.boundedElastic())
                    .subscribe(s -> log.info("thread 1: {}", s), null, countDownLatch::countDown);
        });
        Thread thread3 = new Thread(() -> {
            Mono.fromCallable(this::random)
                    .subscribeOn(Schedulers.boundedElastic())
                    .subscribe(s -> log.info("thread 1: {}", s), null, countDownLatch::countDown);
        });
        thread1.start();
        thread2.start();
        thread3.start();
        countDownLatch.await(10, TimeUnit.SECONDS);
    }

    private String random() {
        Stopwatch started = Stopwatch.createStarted();
        int i = rand.nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long elapsed = started.elapsed(TimeUnit.MICROSECONDS);
        return Thread.currentThread().getName() + "-" + elapsed  + "-" + i;
    }


    /**
     * 模拟一个io阻塞的方法
     *
     * @return String
     */
    private String getStringSync() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello Reactor";
    }
}

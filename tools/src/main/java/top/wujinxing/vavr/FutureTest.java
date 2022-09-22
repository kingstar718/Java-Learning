package top.wujinxing.vavr;

import io.vavr.concurrent.Future;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author 01397208
 * @date 2022-01-18
 * <p>
 * 这个 Future 可不是 java.util.concurrent.Future，但它们都是对异步计算结果的一个抽象。
 * vavr 的 Future 提供了比 java.util.concurrent.Future 更友好的回调机制
 * <p>
 * onFailure 失败的回调
 * onSuccess 成功的回调
 */
public class FutureTest {

    @Test
    public void testFutureFailure() {
        final var word = "hello world";
        Future.of(Executors.newFixedThreadPool(1), () -> word)
                .onFailure(throwable -> Assert.fail("不应该走到failure分支"))
                .onSuccess(result -> Assert.assertEquals(word, result));
    }

    @Test
    public void testFutureSuccess() {
        io.vavr.concurrent.Future
                .of(Executors.newFixedThreadPool(1), () -> {
                    throw new RuntimeException();
                })
                .onFailure(throwable -> Assert.assertTrue(throwable instanceof RuntimeException))
                .onSuccess(result -> Assert.fail("不应该走到 success 分支"));
    }
}

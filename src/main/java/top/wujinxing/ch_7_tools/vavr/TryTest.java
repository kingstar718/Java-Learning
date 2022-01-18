package top.wujinxing.ch_7_tools.vavr;

import io.vavr.control.Try;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author wujinxing
 * @date 2022-01-08
 */
public class TryTest {

    @Test
    public void testTryInstance() {
        // 除以0，构建出Failure
        Try<Integer> error = Try.of(() -> 0 / 0);
        Assert.assertTrue(error instanceof Try.Failure);

        // 合法的加法，构建出Success
        Try<Integer> normal = Try.of(() -> 1 + 1);
        Assert.assertTrue(normal instanceof Try.Success);
    }

    private String testTryWithRecover(Exception e) {
        return (String) Try.of(() -> {
            throw e;
        })
                .recoverWith(NullPointerException.class, Try.of(() -> "NPE"))
                .recoverWith(IllegalStateException.class, Try.of(() -> "IllegalState"))
                .recoverWith(RuntimeException.class, Try.of(() -> "Unknown"))
                .get();
    }

    @Test
    public void testTryWithRecover() {
        Assert.assertEquals("NPE", testTryWithRecover(new NullPointerException()));
        Assert.assertEquals("IllegalState", testTryWithRecover(new IllegalStateException()));
        Assert.assertEquals("Unknown", testTryWithRecover(new RuntimeException()));
    }

    @Test
    public void testTryMap() {
        String res = Try.of(() -> "hello world")
                .map(String::toUpperCase)
                .toOption()
                .getOrElse(() -> "default");
        Assert.assertEquals("HELLO WORLD", res);
    }
}

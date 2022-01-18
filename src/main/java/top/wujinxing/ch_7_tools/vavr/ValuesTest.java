package top.wujinxing.ch_7_tools.vavr;

import io.vavr.control.Option;
import io.vavr.control.Try;
import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;
import java.util.Optional;

/**
 * @author wujinxing
 * @date 2022-01-16
 */
public class ValuesTest {

    @Test
    public void optional() {
        Optional<String> myFoo = Optional.of("foo");
        System.out.println(myFoo.get().equals("foo"));

        Optional<String> myFooBar = myFoo.map(s -> (String) null).map(s -> s.toUpperCase() + "bar");
        System.out.println(myFooBar.isPresent());
    }

    @Test
    public void option() {

    }

    @Test
    public void trys() {
        Try.of(() -> 1 / 0)
                .andThen(r -> System.out.println("and then: " + r))
                .onFailure(error -> System.out.println("failure: " + error.getMessage()))
                .andFinally(() -> {
                    System.out.println("finally");
                });
    }


}

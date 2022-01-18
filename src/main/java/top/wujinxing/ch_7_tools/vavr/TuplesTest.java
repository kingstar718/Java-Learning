package top.wujinxing.ch_7_tools.vavr;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wujinxing
 * @date 2022-01-16
 */
@Slf4j
public class TuplesTest {

    @Test
    public void test() {
        // Create a tuple
        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
        log.info(java8._1);
        // Integer
        log.info(String.valueOf(java8._2));

        // map tuple component
        Tuple2<String, Integer> that = java8.map(
                s -> s.substring(2) + "vr",
                i -> i / 8
        );
        log.info(that.toString());

        // another map
        Tuple2<String, Integer> that2 = java8.map(
                (s, i) -> Tuple.of(s.substring(2) + "vr", i / 8)
        );
        log.info(that2.toString());

        // transform a tuple: Transform creates a new type based on the tuple’s contents.
        String apply = java8.apply(
                (s, i) -> s.substring(2) + "var" + i / 8
        );
        log.info(apply);
    }
}

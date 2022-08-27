package top.wujinxing.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * @author kingstar718
 * @date 2022-08-07
 */
@Slf4j
public class SubscribeDemo {

    public static void main(String[] args) {
        Flux<Integer> range = Flux.range(1, 3);
        range.subscribe();
        range.subscribe(s -> log.info("subscribe: {}", s));

        // error
        Flux<Integer> ints = Flux.range(1, 4).map(i -> {
            if (i <= 3) {
                return i;
            } else {
                throw new RuntimeException("Got to 4");
            }
        });
        ints.subscribe(i -> log.info("print int: {}", i), error -> log.error("Error: ", error));

        // completion events
        Flux<Integer> ints2 = Flux.range(1, 4);
        ints2.subscribe(i -> log.info("print int: {}", i),
                error -> log.error("Error: ", error),
                () -> log.info("subscribe done!"),
                sub -> sub.request(10));
    }

}

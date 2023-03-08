package top.wujinxing.java11;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author wujinxing
 * @date 2023/3/8
 */
@Slf4j
public class Ch6OptionalEnhanced {

    public static void main(String[] args) {
        String javastack = Optional.of("javastack").orElseThrow();
        log.info("javastack: {}", javastack);

        long count = Optional.of("javastack").stream().count();
        log.info("count: {}", count);

        String get = (String) Optional.ofNullable(null)
                .or(() -> Optional.of("javastack"))
                .get();
        log.info("get: {}", get);
    }

}

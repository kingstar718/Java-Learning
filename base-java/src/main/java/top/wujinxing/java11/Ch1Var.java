package top.wujinxing.java11;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author wujinxing
 * @date 2023/3/8
 */
@Slf4j
public class Ch1Var {

    public static void main(String[] args) {
        Arrays.asList("Java", "Python", "Ruby")
                .forEach((var s) -> {
                    log.info("Hello, {}", s);
                });

        var str = "Hello World";
        var i = 12;
        log.info("var str: {}", str);
        log.info("var int: {}", 1);
    }

}

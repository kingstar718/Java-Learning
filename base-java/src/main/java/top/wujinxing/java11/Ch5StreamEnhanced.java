package top.wujinxing.java11;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wujinxing
 * @date 2023/3/8
 */
@Slf4j
public class Ch5StreamEnhanced {

    public static void main(String[] args) {
        // 单个参数构造方法
        long count = Stream.ofNullable(null).count();
        log.info("count: {}", count);

        // 增加takeWhile dropWhile
        List<Integer> collect = Stream.of(1, 2, 3, 2, 1)
                // 从开始结算，当 n < 3 时就截止
                .takeWhile(n -> n < 3)
                .collect(Collectors.toList());
        log.info("collect: {}", collect);
    }

}

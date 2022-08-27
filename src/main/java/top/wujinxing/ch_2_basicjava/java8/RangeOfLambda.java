package top.wujinxing.ch_2_basicjava.java8;

import lombok.extern.slf4j.Slf4j;

/**
 * 对于lambda表达式外部的变量，其访问权限的粒度与匿名对象的方式非常类似。
 * 你能够访问局部对应的外部区域的局部final变量，以及成员变量和静态变量。
 *
 * @author wujinxing
 * @date 2019/3/16 21:40
 */
@Slf4j
public class RangeOfLambda {

    public static void main(String[] args) {
        final int num = 1;
        Converter<Integer, String> stringConverter = from -> String.valueOf(from + num);
        log.info("lambda string converter: {}", stringConverter.convert(2));
    }

    @FunctionalInterface
    interface Converter<F, T> {

        /**
         * 转换
         *
         * @param from F
         * @return T
         */
        T convert(F from);

    }

}

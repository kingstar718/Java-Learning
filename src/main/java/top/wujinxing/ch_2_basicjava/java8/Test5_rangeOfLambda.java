package top.wujinxing.ch_2_basicjava.java8;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/3/16 21:40
 * @description:
 * 对于lambdab表达式外部的变量，其访问权限的粒度与匿名对象的方式非常类似。
 * 你能够访问局部对应的外部区域的局部final变量，以及成员变量和静态变量。
 */
public class Test5_rangeOfLambda {
    @Test
    public void test(){
        final int num = 1;
        Converter<Integer, String> stringConverter = from -> String.valueOf(from+num);
        System.out.println(stringConverter.convert(2));
    }
}

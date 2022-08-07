package top.wujinxing.ch_2_basicjava.java8;

import lombok.extern.slf4j.Slf4j;

/**
 * Java 8 允许我们使用default关键字，为接口声明添加非抽象的方法实现。这个特性又被称为扩展方法。
 *
 * @author wujinxing
 * @date 2019/3/16 20:42
 */
@Slf4j
public class DefMethodInterface {

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        log.info("calculate: {}", formula.calculate(100));
        log.info("sqrt: {}", formula.sqrt(16));
    }

    interface Formula {

        /**
         * 计算
         *
         * @param a 入参
         * @return double
         */
        double calculate(int a);

        /**
         * 默认方法：开根号
         *
         * @param a 入参
         * @return double
         */
        default double sqrt(int a) {
            return Math.sqrt(a);
        }

    }

}
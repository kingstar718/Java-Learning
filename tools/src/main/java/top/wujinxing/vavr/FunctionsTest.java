package top.wujinxing.vavr;

import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function5;
import io.vavr.control.Option;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wujinxing
 * @date 2022-01-16
 */
@Slf4j
public class FunctionsTest {

    public static void main(String[] args) {

        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Integer apply = sum.apply(1, 2);
        System.out.println(apply);

        // Composition，多个函数的组合
        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyTwo = a -> a * 2;
        Function1<Integer, Integer> and1AndMultiplyBy2 = plusOne.andThen(multiplyTwo);
        System.out.println(and1AndMultiplyBy2.apply(2).equals(6));
        // or compose
        Function1<Integer, Integer> compose = multiplyTwo.compose(plusOne);
        System.out.println(compose.apply(2).equals(6));

        //Lifting
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);
        Option<Integer> i1 = safeDivide.apply(1, 0);
        Option<Integer> i2 = safeDivide.apply(4, 2);
        // print None
        System.out.println(i1);
        // pring Some(2)
        System.out.println(i2);

        // Partial application
        Function2<Integer, Integer, Integer> sum2 = (a, b) -> a + b;
        Function1<Integer, Integer> add2 = sum2.apply(2);
        System.out.println(add2.apply(4).equals(6));

        // 部分算值
        Function5<Integer, Integer, Integer, Integer, Integer, Integer> sum5 = (a, b, c, d, e) -> a + b + c + d + e;
        Function2<Integer, Integer, Integer> add6 = sum5.apply(2, 3, 1);
        System.out.println(add6.apply(4, 3).equals(13));

        // Memoization
        Function0<Double> hashCache =
                Function0.of(Math::random).memoized();

        double randomValue1 = hashCache.apply();
        double randomValue2 = hashCache.apply();
        System.out.println(randomValue1 == randomValue2);

    }

}

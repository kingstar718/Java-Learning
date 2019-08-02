package top.wujinxing.ch_2_basicjava.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/3/16 20:49
 * @description:    Lambda表达式
 */
public class Test2_lambda {

    public static void main(String[] args){
        List<String> names = Arrays.asList("peter","anna","mike","xenia");

        //静态工具方法Collections.sort接受一个list，
        // 和一个Comparator接口作为输入参数，
        // Comparator的实现类可以对输入的list中的元素进行比较。
        // 通常情况下，你可以直接用创建匿名Comparator对象，并把它作为参数传递给sort方法。
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        //Lambda
        Collections.sort(names,(String a, String b)->{
            return b.compareTo(a);
        });

        Collections.sort(names,(String a, String b)->b.compareTo(a));

        Collections.sort(names,(a, b)->b.compareTo(a));

        System.out.println(names);
    }
}

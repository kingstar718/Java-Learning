package top.wujinxing.ch_3_algorithm.recursive;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/1/9 15:58
 * @description:递归
 */
public class Recursive {
    public static int sumOf(int n){
        int sum;
        if (n == 1){
            return 1;
        }else {
            sum = sumOf(n-1) + n;
        }
        return sum;
    }

    @Test
    public void test1(){
        System.out.println(sumOf(6));
    }
}

package top.wujinxing.ch_5_questions.SwordOffer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/9/4 13:40
 * description 斐波那契数
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class ch_07_Fibonacci {

    //递归
    public int Fibonacci(int n) {
        if (n < 1)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);

    }

    //递归
    public int dpFibonacci(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        int f1 = 1, f2 = 1, res = 0;
        //i从3开始
        for (int i = 3; i < n; i++) { //可不要另外开辟数组来存结果值
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(Fibonacci(10));
        System.out.println(dpFibonacci(10));
    }

}

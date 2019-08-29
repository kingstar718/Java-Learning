package top.wujinxing.ch_5_questions.offer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019/4/30 09:01
 * description  不用加减乘除做加法
 *
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class _48_Add {
    public static void main(String[] args) {
        System.out.println(add(4,5));
        System.out.println(add(66,3333));
    }

    /**
     * 首先看十进制是如何做的： 5+7=12，三步走
     * 第一步：相加各位的值，不算进位，得到2。
     * 第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。     *
     * 第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。
     * *
     * 同样我们可以用三步走的方式计算二进制值相加： 5-101，7-111 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
     *
     * 第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
     *
     * 第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
     *      继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
     * @param a
     * @param b
     * @return re
     */
    private static int add(int a, int b){
        //a^b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
        //递归会终止的原因是 (a & b) << 1 最右边会多一个 0，那么继续递归，进位最右边的 0 会慢慢增多，最后进位会变为
        //0，递归终止
        return b == 0 ? a : add(a^b, (a&b)<<1);
    }

    @Test
    public void test(){
        System.out.println(4^5);
        System.out.println((4&5)<<1);
    }
}

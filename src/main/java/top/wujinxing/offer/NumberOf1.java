package top.wujinxing.offer;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/4/18 11:09
 * @description: 输入一个整数，输出该数二进制表示中 1 的个数
 */
public class NumberOf1 {

    /**
     * n&(n-1)
     * 该位运算去除 n 的位级表示中最低的那一位。
     * n : 10110100
     * n-1 : 10110011
     * n&(n-1) : 10110000
     * 时间复杂度：O(M)，其中 M 表示 1 的个数
     */
    public int NumberOf1_1(int n) {
        int cnt = 0;
        while (n != 0){
            cnt++;
            n &= (n-1);
        }
        return cnt;
    }

    public int NumberOf1_2(int n) {
        return Integer.bitCount(n);
    }

    @Test
    public void Test(){
        int a = 3;
        int b = 55;
        int c = 456;
        System.out.println(NumberOf1_1(a)+ " " + NumberOf1_1(b) + " " +NumberOf1_1(c));
        System.out.println(NumberOf1_2(a)+ " " + NumberOf1_2(b) + " " +NumberOf1_2(c));
    }
}

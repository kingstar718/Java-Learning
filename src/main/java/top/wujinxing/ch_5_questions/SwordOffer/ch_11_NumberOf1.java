package top.wujinxing.ch_5_questions.SwordOffer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/9/4 16:14
 * description 二进制中1的个数
 */
public class ch_11_NumberOf1 {

    /**
     * 把一个整数减去 1 再和原整数做 与 运算，会把该整数最右边一个 1 变成 0。
     * 那么一个整数的二进制表示中有多少个 1，就可以进行多少次这样的操作。
     * n&(n-1)
     * 该位运算去除 n 的位级表示中最低的那一位。
     * n : 10110100
     * n-1 : 10110011
     * n&(n-1) : 10110000
     * 时间复杂度：O(M)，其中 M 表示 1 的个数
     *
     * @param n 参数
     * @return 个数
     */
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    @Test
    public void test() {
        System.out.println(NumberOf1(10));
        System.out.println(NumberOf1(2));
    }
}

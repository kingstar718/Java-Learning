package top.wujinxing.LeetCode.DynamicProgramming;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/4/6 23:52
 * @description: 有 N 阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法。
 *
 *
 */
public class _70_Climbing_Stairs_easy {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    @Test
    public void test(){
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }
}

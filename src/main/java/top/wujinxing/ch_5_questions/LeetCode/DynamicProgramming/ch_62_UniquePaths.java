package top.wujinxing.ch_5_questions.LeetCode.DynamicProgramming;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/11/18 19:58
 * description 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 * <p>
 * 链接：https://leetcode-cn.com/problems/unique-paths
 */
public class ch_62_UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) return 0;
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;

        // 公式：dp[i] = dp[i-1] + dp[i]
        for (int i = 1; i < m; i++) {
            dp[0] = 1;  //每i行的首个都是1
            for (int j = 1; j < n; j++)
                dp[j] = dp[j - 1] + dp[j];
        }
        return dp[n - 1];
    }

    @Test
    public void test() {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
    }
}

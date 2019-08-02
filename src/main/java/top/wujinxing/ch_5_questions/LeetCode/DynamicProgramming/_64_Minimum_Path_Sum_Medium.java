package top.wujinxing.ch_5_questions.LeetCode.DynamicProgramming;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/4/7 23:53
 * @description:
 * [[1, 3, 1],
 *  [1,5,1],
 *  [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 * 题目描述：求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
 */
public class _64_Minimum_Path_Sum_Medium {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = dp[j]; // 只能从上侧走到该位置
                } else if (i == 0) {
                    dp[j] = dp[j - 1]; // 只能从左侧走到该位置
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
    }

    @Test
    public void test(){
        int[][] a = {{1,3,1},
                     {1,5,1},
                     {4,2,1}};
        System.out.println(minPathSum(a));
    }
}

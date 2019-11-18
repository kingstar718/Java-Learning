package top.wujinxing.ch_5_questions.LeetCode.DynamicProgramming;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/11/18 21:15
 * description 编辑距离
 * <p>
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1:
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 示例 2:
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 链接：https://leetcode-cn.com/problems/edit-distance
 */
public class ch_72_EditDistance {

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int j = 1; j < n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        for (int i = 1; i < n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    public int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) return n + m;

        int dp[] = new int[m + 1];

        for (int j = 0; j <= m; j++) dp[j] = j;
        int temp, pre;
        for (int i = 1; i <= n; i++) {
            temp = dp[0];
            dp[0] = i;
            for (int j = 1; j <= m; j++) {
                // pre 相当于之前的 dp[i-1][j-1]
                pre = temp;
                temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[j] = pre;
                else
                    dp[j] = Math.min(Math.min(dp[j - 1], pre), dp[j]) + 1;
            }
        }
        return dp[m];
    }

    @Test
    public void test() {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance2("horse", "ros"));
    }
}

package top.wujinxing.cracking_the_coding_interview;

import org.junit.Test;

/**
 * 硬币表示
 *
 * 有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。
 *
 * 给定一个int n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。
 *
 * 测试样例：
 * 6
 * 返回：2
 */

public class ch_9_8_countWays {

    public int countWays(int n) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[100001];
        dp[0] = 1;
        for (int i=0; i<4; i++){
            for (int j=coins[i]; j<=n; j++){
                dp[j] = (dp[j]+dp[j-coins[i]])%1000000007;
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(countWays(6));
    }
}

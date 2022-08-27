package top.wujinxing.cracking_the_coding_interview;

/**
 * @author wujinxing
 * date 2019 2019/8/19 20:23
 * description 机器人走方格1
 *
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 *
 * 测试样例：
 * 2,2
 * 返回：2
 */
public class ch_9_2_1_countWays {

    public static void main(String[] args) {
        System.out.println(countWays(5,4));
        System.out.println(countWays2(5,4));
    }

    private static int countWays(int x, int y) {
        if (x<=0 || y<=0) return 0;
        if (x==1 || y==1) return 1;
        return countWays(x-1, y) + countWays(x, y-1);
    }

    //dp
    // 题目要求走的是大格子而不是网格线的交点，所以有两种走法。
    // 二维数组用于计算走到当前格子的走法总数，为其上方格子走法总数与其左侧格子走法总数之和
    private static int countWays2(int x, int y){
        int[][] dp = new int[x][y];
        dp[0][0] = 1;

        for (int i=1; i<x; i++){
            dp[i][0] = dp[i-1][0];
        }

        for (int i=1; i<y; i++){
            dp[0][i] = dp[0][i-1];
        }

        for (int i=1; i<x; i++){
            for (int j=1; j<y; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];//上方格子走法总数与其左侧格子走法总数之和
            }
        }

        return dp[x-1][y-1];
    }
}

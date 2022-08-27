package top.wujinxing.cracking_the_coding_interview;

/**
 * @author wujinxing
 * date 2019 2019/8/19 21:09
 * description 机器人走方格2
 *
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
 * 请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。
 *
 * 给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。
 * 另外给定int x,int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，为了防止溢出，请将结果Mod 1000000007。
 * 保证x和y均小于等于50
 */
public class ch_9_2_2_countWays {

    /**
     *1.判断右下角的点以及起点自身是否为障碍点，若是返回0；
     * 2.若右下角的点非障碍点，判断上面和左边是否为障碍点
     * 1.若全都为障碍点，返回0
     * 2.若一个为障碍点，一个不是，则到该点的路径数等于上一个点的路径数（这是递归的思路）
     * 第2部分可以不用递归，而用循环：
     * dp[i-1][j-1]表示从(0,0)到(i,j)的方法数，如果(i,j)非1，则为障碍点，对应dp[i-1][j-1]为0
     * 其余情况与一般dp相同
     */
    private static int countWays(int[][] map, int x, int y) {
        if (map==null || map.length!=x || map[0].length!=y) return 0;
        if (map[x-1][y-1]!=1 || map[0][0]!=1) return 0; //起点终点为障碍点

        int dp[][] = new int[x][y];
        dp[0][0] = 1;
        for (int i=1; i<x; i++){
            if (map[i][0]!=1){
                dp[i][0] = 0;
            }else {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i=1; i<y; i++){
            if (map[0][i]!=1){
                dp[0][i] = 0;
            }else {
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i=1; i<x; i++){
            for (int j=1; j<y; j++){
                if (map[i][j]!=1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j]%1000000007 + dp[i][j-1]%1000000007;
                }
            }
        }
        return dp[x-1][y-1]%1000000007;
    }
}

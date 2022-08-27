package top.wujinxing.cracking_the_coding_interview;

/**
 * @author wujinxing
 * date 2019 2019/8/21 21:33
 * description
 *
 * 在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，在这个矩阵中有的格子有一些建筑，
 * 洪水只能在没有建筑的格子流动。请返回洪水流到(n - 1,m - 1)的最早时间(洪水只能从一个格子流到其相邻的格子
 * 且洪水单位时间能从一个格子流到相邻格子)。
 *
 * 给定一个矩阵map表示城市，其中map[i][j]表示坐标为(i,j)的格子，值为1代表该格子有建筑，0代表没有建筑。
 * 同时给定矩阵的大小n和m(n和m均小于等于100)，请返回流到(n - 1,m - 1)的最早时间。保证洪水一定能流到终点。
 */
public class ch_9_7_floodFill {

    private static int floodFill(int[][] map, int n, int m) {
        if (map==null || map.length!=n || map[0].length !=m) return 0;
        if (map[n-1][m-1]==1 || map[0][0]==1) return 0;

        int dp[][] = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int i=1; i<n; i++){
            if (map[i][0]==0){
                dp[i][0] = dp[i-1][0]+1;
            }else {
                break;
            }
        }
        for (int i=1; i<m; i++){
            if (map[0][i] ==0){
                dp[0][i] = dp[0][i-1]+1;
            }else {
                break;
            }
        }
        for (int i=1; i<n; i++){
            for (int j=1; j<m; j++){
                if (map[i][j] == 0){
                    if (dp[i-1][j]!=Integer.MAX_VALUE || dp[i][j-1]!=Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
}

package top.wujinxing.leetcode.dynamic_programming;

/**
 * @author wujinxing
 * date 2019 2019/8/22 19:30
 * description (地下城游戏)(dp)
 *
 * 恶魔抓住了公主（P）并将她关在地牢的右下角。地牢由M x N个房间组成，以2D网格布局。
 * 我们英勇的骑士（K）最初位于左上角的房间，必须通过地牢来拯救公主。
 * 骑士的初始健康点由正整数表示。如果他的健康点在任何时候降至0或以下，他立即死亡。
 * 有些房间是由恶魔守卫的，因此骑士进入这些房间时会失去健康（负整数）;
 * 其他房间要么空（0），要么包含增加骑士健康的魔法球（正整数）。
 * 为了尽快到达公主，骑士决定在每一步中仅向右或向下移动。
 */
public class _174_Dungeon_Game {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length<=0 || dungeon[0].length<=0)
            return 0;

        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = dungeon[n-1][m-1] > 0 ? 1: -dungeon[n-1][m-1]+1;

        for (int j=m-2; j>=0; j--){
            dp[n-1][j] = dungeon[n-1][j] >= dp[n-1][j+1] ? 1: dp[n-1][j+1]-dungeon[n-1][j];
        }

        for (int i=n-2; i>=0; i--){
            dp[i][m-1] = dungeon[i][m-1] >= dp[i+1][m-1] ? 1: dp[i+1][m-1]-dungeon[i][m-1];
        }

        for (int i=n-2; i>=0; i--){
            for (int j=m-2; j>=0; j--){
                dp[i][j] = (dungeon[i][j]>= Math.min(dp[i][j+1], dp[i+1][j]))?
                        1: Math.min(dp[i][j + 1], dp[i + 1][j])-dungeon[i][j];
            }
        }
        return dp[0][0];
    }

}

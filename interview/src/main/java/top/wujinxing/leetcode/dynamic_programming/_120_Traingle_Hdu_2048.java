package top.wujinxing.leetcode.dynamic_programming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/8/22 10:34
 * description 数塔问题(简单dp)
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *给定一个三角形，找到从上到下的最小路径总和。您可以移动到下面一行中相邻数字的每一步。
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * 如果能够仅使用O（n）额外空间来执行此操作，则可获得奖励点，其中n是三角形中的总行数。
 */
public class _120_Traingle_Hdu_2048 {

    /**
     * 递归的思路是从上到下：
     * 递归函数有两个主要的参数，记录行和列，表示当前行的位置是matrix[r][c]，要向下去求最小路径；
     * 如果行 r == n，说明不需要向下求，则直接返回matrix[r][c]；
     * 否则先给我递归求出从matrix[r+1][c]求出的最大路径，和从matrix[r+1][c+1]的最大路径，我取最大的，和自己相加即可；
     * 然后用二维数组map记忆化即可；
     */

    private int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;

        int n = triangle.size();
        int m = triangle.get(n-1).size();

        dp = new int[n][m];
        return rec(triangle, 0, 0, n-1);
    }

    private int rec(List<List<Integer>> triangle, int r, int c, int level) {
        if (r == level){
            return triangle.get(r).get(c);
        }
        if (dp[r][c] != 0){
            return dp[r][c];
        }
        int ele = triangle.get(r).get(c);
        dp[r][c] = Math.min(
                ele + rec(triangle, r+1, c, level),
                ele + rec(triangle, r+1, c+1, level)
        );
        return dp[r][c];
    }

    //二维dp
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;

        int n = triangle.size();
        int m = triangle.get(n-1).size();

        dp = new int[n][m];

        for (int i=0; i<m; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for (int i=n-2; i>=0; i--){
            for (int j=0; j<=i; j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

    //一维dp
    public int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;

        int n = triangle.size();
        int m = triangle.get(n-1).size();

        int[] dp1 = new int[m];

        for (int i=0; i<m; i++){
            dp1[i] = triangle.get(n-1).get(i);//先存了最后一行的值
        }

        for (int i=n-2; i>=0; i--){
            for (int j=0; j<=i; j++){
                //更新值的时候，将当前行的值+前面一行的两个值比较大小，使用较小的值
                dp1[j] = triangle.get(i).get(j) + Math.min(dp1[j], dp1[j+1]);
            }
        }
        return dp1[0];
    }

    @Test
    public void test(){
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        List<List<Integer>> l = new ArrayList<>();
        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);
        System.out.println(minimumTotal(l));
        System.out.println(minimumTotal2(l));
        System.out.println(minimumTotal3(l));
    }
}

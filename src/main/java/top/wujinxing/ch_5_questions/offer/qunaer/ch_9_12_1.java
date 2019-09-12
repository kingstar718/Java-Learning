package top.wujinxing.ch_5_questions.offer.qunaer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/12 15:23
 * description 求n维数组的最大子数组
 * <p>
 * 设有n*n的矩阵数组，元素分别为a00  a01 ... a0(n-1) a10 a11 ... a1(n-1) ... ... a(n-1)0 a(n-1)1 ... a(n-1)(n-1)，
 * 求其所有子矩阵中所有元素相加的和的最大值max
 * <p>
 * 输入
 * n
 * a00  a01 ... a0(n-1) a10 a11 ... a1(n-1) ... ... a(n-1)0 a(n-1)1 ... a(n-1)(n-1)
 * （数据范围：n在1到100之间，每个数在-128到127之间）
 * <p>
 * 输出
 * max
 * <p>
 * 样例输入
 * 2
 * -1 2 -3 6
 * 样例输出
 * 8
 */
public class ch_9_12_1 {

    //33%AC  做法有问题 n*n内子矩阵的概念
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }*/
        int[][] arr = {{-1, 2, -2}, {-3, 3, 6}, {-2, 4, 5}};
        int n = 3;
        System.out.println(fun(arr, n));
    }

    private static int fun(int[][] arr, int n) {
        if (arr == null || arr.length != n || arr[0].length != n)
            return 0;
        int[] dp = new int[n * n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list.add(arr[i][j]);
            }
        }
        int[] temp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i);
        }
        dp[0] = temp[0];
        for (int i = 1; i < n * n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 1] + temp[i], temp[i]));
        }
        return dp[n * n - 1];
    }
}

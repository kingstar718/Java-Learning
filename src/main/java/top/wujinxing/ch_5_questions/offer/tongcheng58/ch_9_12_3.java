package top.wujinxing.ch_5_questions.offer.tongcheng58;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/12 20:55
 * description 走地图
 * 求最小路径
 * m*n的地图
 * 输入
 * 3
 * 3
 * 1 3 4
 * 2 1 2
 * 4 3 1
 */
public class ch_9_12_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        /*int m = 3;
        int n = 3;
        int[][] arr = {{1, 3, 4}, {2, 1, 2}, {4, 3, 1}};*/
        System.out.println(fun(m, n, arr));
    }

    //100%AC
    private static int fun(int m, int n, int[][] arr) {
        int[][] dp = new int[m][n];
        dp[0][0] = arr[0][0];
        for (int j=1; j<n; j++){
            dp[0][j] = dp[0][j-1] + arr[0][j];
        }
        for (int i=1; i<m; i++){
            for (int j=0; j<n; j++){
                if (j==0){
                    dp[i][j] = dp[i-1][j]+arr[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1]+arr[i][j],dp[i-1][j]+arr[i][j]);
                }
            }
        }/*
        for (int[] i: dp
             ) {
            System.out.println(Arrays.toString(i));
        }*/

        return dp[m-1][n-1];
    }
}

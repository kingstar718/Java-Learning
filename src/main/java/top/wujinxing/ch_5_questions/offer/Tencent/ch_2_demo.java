package top.wujinxing.ch_5_questions.offer.Tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/1 20:19
 * description
 * <p>
 * 第一行一个整数n，表示顾客数量
 * 接下来n行，第i行包含两个整数a1 b1 用一个空格分隔
 * <p>
 * 输出一个整数，表示最小的不满意度总和
 * <p>
 * 不满意度  第i位位于位置j = ai*(j-1)+bi*(n-1)
 */
public class ch_2_demo {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        sc.close();*/
        int n = 3;
        int[][] arr = {{1, 3}, {1, 1}, {4, 1}};
       int[][] dp = new int[n][n];
       for (int i=0; i<n; i++){
           dp[0][i] = com2(arr[0],i+1, n);
       }
        System.out.println(Arrays.toString(dp[0]));
       for (int i=1; i<=n; i++){
           dp[i][0] = com2(arr[i],i+1, n);
           for (int j=1; j<=n; j++){

           }
       }

        //首先，初始的每个顾客的不满意度为 ai*(i-1)+bi*(n-i)
        //求的是，排过号之后，每个顾客新位置后，假设此时第i位顾客的位置为j，有ai*(j-1)+bi(n-j)
    }

    private static int com(int[][] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i][0] * (i + 1 - 1) + arr[i][1] * (n - i - 1);
        }
        return sum;
    }

    private static int com2(int[] arr, int i, int n) {
        return arr[0] * (i - 1) + arr[1] * (n - i);
    }
}

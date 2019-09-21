package top.wujinxing.ch_5_questions.sensetime;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/21 19:38
 * description
 * <p>
 * 每次只能从下或者往右
 * 从左上走到右下共几种走法
 */
public class ch_9_21_1 {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();*/
        System.out.println(fun(3, 2));
        System.out.println(fun2(3, 2));
    }

    //33%AC
    private static int fun(int m, int n) {
        if (n <= 0 || m <= 0)
            return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int cur = 0;
        for (int i = 1; i < m; i++) {
            cur = 1;
            for (int j = 1; j < n; j++) {
                cur = cur + dp[j];
                dp[j] = cur;
            }
        }
        return dp[n-1];
    }

    //83%AC
    private static int fun2(int m, int n) {
        int N = n + m - 2;
        int K = n - 1;
        double res = 1.0;
        for (int i = 1; i <= n - 1; i++) {
            res = res * (N - K + i) / i;
        }
        return (int) res;
    }
}

package top.wujinxing.ch_5_questions.offer.bilibili;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/20 19:49
 * description
 *
 * c[i][j] 前i件物品放入一个重量为j的背包可以获得最大价值
 *          背包容量不足则肯定不能放入
 *          c[i][j] = c[i-1][j] j<M
 *          背包容量充足，看放入、不放入哪种情况获得的价值最大：
 *          c[i][j] = max{c[i-1][j], c[i-1][j-w[i]]+v[i]}  v>=M
 */
public class bag {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] w = new int[N];
        int[] v = new int[N];*/
        int N = 5;
        int M = 10;
        int[] w = {2,2,6,5,4};
        int[] v = {6,3,5,4,6};
        /*for (int i=0; i<N; i++){
            w[i] = sc.nextInt();
        }
        for (int i=0; i<N; i++){
            v[i] = sc.nextInt();
        }*/

        int[][] dp = new int[N+1][M+1];
        for (int i=0; i<N; i++){
            dp[i+1][0] = 0;
        }
        for (int i=0; i<=M; i++){
            dp[0][i] = 0;
        }
        for (int i=1; i<=N; i++){
            for (int j=1; j<=M; j++){
                if (j < w[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    int m = dp[i-1][j-w[i-1]] + v[i-1];
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]]+v[i-1]);
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}

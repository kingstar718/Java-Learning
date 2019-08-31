package top.wujinxing.ch_5_questions.offer.shunfeng;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/8/29 19:28
 * description 求最长特殊子序列
 * <p>
 * 子序列定义 1<=i1<=i2...<=ik<=n
 * ai1 ai2 ai3...aik则为一个子序列
 * 性质C定义 ai1<=ai2<=ai3 则称子序列ai1 ai2 ..aik满足性质C
 * <p>
 * 第一行n个数代表序列长度，接下来一行n个数ai，代表序列中的每个数
 * <p>
 * 输出：一行一个数，代表最长的满足性质C的子序的长度
 */
public class ch_2_demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        //int n = 5;
        //int[] arr = {1, 2, 1, 3, 4};

        System.out.println(func(n, arr));
    }

    private static int func(int n, int[] arr) {
        if (n <= 0 || arr == null || arr.length != n)
            return 0;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] >= arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[i] + 1;
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        Arrays.sort(dp);
        return dp[n-1];
    }
}

package top.wujinxing.ch_5_questions.offer.meituan;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/7 19:01
 * description
 * 给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，
 * 编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
 *
 * 输入描述:输入包括一个整数n(1 ≤ n ≤ 10000)
 * 输出描述:输出一个整数,表示不同的组合方案数
 *
 * 输入例子1:1
 * 输出例子1: 1
 *
 * 需要拼凑的面额是n，
 *     维护dp[i],表示取到i时的组合数目，dp[0]=1，
 *     面额数组a[6]={1,5,10,20,50,100}，
 *     dp[j]=dp[j]+dp[j-a[i]],约数条件j>a[i]。
 *     因为面额数目任意，所以需要分别处理只有面额1时，
 *     组合钱数为1~n的各自组合数dp[1]~dp[n],
 *     然后有面额1,5时，组合钱数为1~n的各自组合数dp[1]~dp[n],
 *     依此内推。。。详情见程序。
 */
public class RMB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(fun(num));
    }

    private static long fun(int num) {
        if (num <= 0) return 0;

        long[] dp = new long[num+1];
        dp[0] = 1L;
        int[] coins = new int[]{1, 5, 10, 20, 50, 100};
        for (int i=0; i<coins.length; i++){
            for (int j=coins[i]; j<=num; j++){
                if(j>=coins[i]) dp[j] += dp[j-coins[i]]; //if条件加不加都成立
            }
        }
        return dp[num];
    }
}

package top.wujinxing.offer;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/7/1 11:06
 * description 丑数
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。
 * 习惯上我们把 1 当做是第一个丑数。
 * 求按从小到大的顺序的第 N 个丑数
 * 1 2 3 4 5 6 7 8  9 10 11 12 13 14 15 16 17 18 19 20
 * 1 2 3 4 5 6 8 9 10 12 15 16 18 20 24 25 27 30 32 36
 */
public class _49_UglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数字：");
        int num = sc.nextInt();
        System.out.println(getUglyNumber(num));
    }

    private static int getUglyNumber(int N){
        if(N <= 6){
            return N;
        }
        int i2=0, i3=0, i5=0;
        int[] dp = new int[N];
        dp[0] = 1;
        for(int i=1; i<N; i++){
            int next2 = dp[i2]*2, next3 = dp[i3]*3, next5 = dp[i5]*5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if(dp[i] == next2) i2++;
            if(dp[i] == next3) i3++;
            if(dp[i] == next5) i5++;
        }
        return dp[N-1];
    }
}

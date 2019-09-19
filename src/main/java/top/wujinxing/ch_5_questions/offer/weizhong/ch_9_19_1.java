package top.wujinxing.ch_5_questions.offer.weizhong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/19 16:30
 * description 末尾的数
 *
 * 小明想想知道n！最后一位不为0的数字
 */
public class ch_9_19_1 {

    public static void main(String[] args) {
        /**
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();*/
        int n = 100;
        long sum = funN(n);
        System.out.println(sum);
        String s = String.valueOf(sum);
        for (int i=s.length()-1; i>0; i--)
            if (s.charAt(i) != '0'){
                System.out.println(s.charAt(i));
                break;
            }

        System.out.println(funN2(1000));
    }

    public static long funN(int n){
        long sum = n;
        if (n == 1)
            return sum;
        else
            sum = funN(n-1) * sum;
        return sum;
    }

    public static long funN2(int n){
        long[] dp = new long[n+1];
        String[] s = new String[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1]*i;
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

}

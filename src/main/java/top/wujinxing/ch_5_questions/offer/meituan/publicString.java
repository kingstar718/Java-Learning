package top.wujinxing.ch_5_questions.offer.meituan;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/7 19:39
 * description
 * 给出两个字符串（可能包含空格）,找出其中最长的公共连续子串,输出其长度。
 *
 * 输入描述:
 * 输入为两行字符串（可能包含空格），长度均小于等于50.
 * 输出描述:
 * 输出为一个整数，表示最长公共连续子串的长度。
 *
 * 输入例子1:
 * abcde
 * abgde
 * 输出例子1:2
 */
public class publicString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(fun(s1,s2));
    }
    private static int fun(String s1, String s2){
        if (s1.length()<1 || s2.length()<1) return 0;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i=0; i<s1.length(); i++){
            if (c1[i]==c2[0]) dp[i][0] = 1;
        }
        for (int i=0; i<s2.length(); i++){
            if (c2[i]==c1[0]) dp[0][i] = 1;
        }
        int Max = dp[0][0];
        for (int i=1; i<s1.length(); i++){
            for (int j=1; j<s2.length(); j++){
                if (c1[i]==c2[j]) dp[i][j] = dp[i-1][j-1]+1;
                if (dp[i][j]>Max) Max = dp[i][j];
            }
        }
        return Max;
    }
}

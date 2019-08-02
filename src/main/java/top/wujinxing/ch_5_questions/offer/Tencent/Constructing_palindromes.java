package top.wujinxing.ch_5_questions.offer.Tencent;

import java.util.Scanner;

/**
 * @author: wujinxing
 * @date: 2019/4/15 09:18
 * @description: 构造回文
 *
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数。
 *
 * 输入描述:
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 *
 * 输出描述:
 * 对于每组数据，输出一个整数，代表最少需要删除的字符个数。
 *
 * 输入例子1:
 * abcda
 * google
 *
 * 输出例子1:
 * 2
 * 2
 */
public class Constructing_palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(str.length()-getResult(str));
        }
    }
    public static int getResult(String str){
        StringBuilder sb = new StringBuilder(str);
        String newStr = sb.reverse().toString();
        char[] c1 = str.toCharArray();
        char[] c2 = newStr.toCharArray();
        int n = str.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++){
            for (int j=1; j < n+1; j++){
                if (c1[i-1]==c2[j-1]){ //即原字符串首尾比较
                    dp[i][j] = dp[i-1][j-1]+1; //相等,
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}

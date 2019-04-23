package top.wujinxing.offer.Aqiyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 题目描述
 * 牛牛参加了一场考试,考试包括n道判断题,
 * 每做对一道题获得1分,牛牛考试前完全没有准备,
 * 所以考试只能看缘分了,牛牛在考试中一共猜测了t道题目的答案是"正确",
 * 其他的牛牛猜为"错误"。
 * 考试结束后牛牛知道实际上n道题中有a个题目的答案应该是"正确",
 * 但是牛牛不知道具体是哪些题目,牛牛希望你能帮助他计算可能获得的最高的考试分数是多少。
 * 输入描述:
 * 输入包括一行,一行中有三个正整数n, t, a(1 ≤ n, t, a ≤ 50), 以空格分割
 * 输出描述:
 * 输出一个整数,表示牛牛可能获得的最高分是多少。
 * 示例1
 * 输入
 * 3 1 2
 * 输出
 * 2
 */
public class changeRight {
   public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(), t = sc.nextInt(), a = sc.nextInt();
            System.out.println(helper(n, t, a));
        }
    }

    public static int helper(int n, int t, int a){
        if (t>a) return n-a+t;
        else return a+n-t;
    }
   // n
   // n道题， 猜t道正确， 总共a道正确
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]), t = Integer.parseInt(strs[1]), a = Integer.parseInt(strs[2]);
        System.out.println(Math.min(t, a) + Math.min(n - t, n - a));
    }*/
}


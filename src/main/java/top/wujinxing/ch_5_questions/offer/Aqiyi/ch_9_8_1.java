package top.wujinxing.ch_5_questions.offer.Aqiyi;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/8 15:24
 * description 排列计数
 * <p>
 * 给定一个长度为N-1且只包含0和1的序列A1到AN-1，如果一个1到N的排列P1到PN满足对于1≤i<N，
 * 当Ai=0时Pi<Pi+1，当Ai=1时Pi>Pi+1，则称该排列符合要求，那么有多少个符合要求的排列？
 * <p>
 * 输入
 * 第一行包含一个整数N，1<N≤1000。
 * 第二行包含N-1个空格隔开的整数A1到AN-1，0≤Ai≤1
 * <p>
 * 输出
 * 输出符合要求的排列个数对109+7取模后的结果。
 * <p>
 * 样例输入
 * 4
 * 1 1 0
 * 样例输出
 * 3
 * 提示
 * 样例解释
 * 符合要求的排列为{3 2 1 4}、{4 2 1 3}和{4 3 1 2}。
 */
public class ch_9_8_1 {

    //18%
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            A[i] = sc.nextInt();
        }*/
        System.out.println(fun(new int[]{1, 1,0}, 4));
    }

    private static int fun(int[] A, int N) {
        if (A == null || A.length != N - 1 || N <= 0) {
            return 0;
        }
        int a1 = 1;
        for (int i = N; i > 2; i--) {
            a1 *= i;
        }
        int sum = a1 / 2;

        return sum-A.length;
    }
}

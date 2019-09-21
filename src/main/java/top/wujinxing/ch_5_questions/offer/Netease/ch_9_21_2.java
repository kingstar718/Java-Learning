package top.wujinxing.ch_5_questions.offer.Netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/21 15:35
 * description 翻倍
 *
 * 给定A,B和系数p，q
 * 每次操作你可以将A+p 或者将p变成p+q，问至少几次操作使得B<=A
 *
 * 输入：
 * 第一行T表示共有T组测试用例
 * 接下来T行为四个数表示A B p q
 *
 * 输出：
 * T行表示次数
 *
 * 输入用例：
 * 2
 * 1 5 7 2
 * 3 5 1 2
 * 输出：
 * 1
 * 2
 * 输入用例：
 * 2
 * 1 15 4 2
 * 12 19 3 2
 * 输出：
 * 3
 * 3
 */
public class ch_9_21_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] arr = new int[T][4];
        for (int i=0; i<T; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            arr[i][3] = sc.nextInt();
        }
        for (int[] i:arr)
            System.out.println(Arrays.toString(i));
    }
}

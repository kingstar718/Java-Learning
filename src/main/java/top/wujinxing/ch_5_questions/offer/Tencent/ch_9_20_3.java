package top.wujinxing.ch_5_questions.offer.Tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/20 20:36
 * description
 * <p>
 * 题目描述
 * 2020年一共有n名员工参加入职培训,第名员工拥有一个战力值x[。
 * 在入职培训中有一个小活动需要把所有员分为A、B两组进行比拼对决。
 * 为了让活动更有趣味性,小Q希望两组的人数尽量均分即两组人数之差不超过1),
 * 并且要让两组尽量势均力敌(A组的战力值之和与B组的战力值之和的差值尽量小)
 * 小Q把这个问题交给你了,希望你帮他完成这个分组问题。
 * <p>
 * 输入描述:
 * 输入的第一行包含一个正整数(1<=<=10),表示测试用例数对于每一组测试用例,
 * 输入的一行包括一个正整数n(2<=n<=100),表示员工的数量.
 * 接下来的一行,包含n个正整数x[i](1<=x[i]<=10^5)保证所有员工的战力值之和小于等于10^5
 * <p>
 * 输出描述:
 * 输出两个整数,从小到大依次输出两组的战力值之和
 * <p>
 * 输入
 * 2
 * 4
 * 5 9 4 7
 * 8
 * 9 13 18 10 12 4 18 3
 * 输出
 * 12 13
 * 43 44
 */
public class ch_9_20_3 {

    //0%AC
    public static void main(String[] args) {
        /**
         Scanner sc = new Scanner(System.in);
         int T = Integer.parseInt(sc.nextLine());
         int n = 2 * T;
         String[] arr = new String[n];
         for (int i = 0; i < n; i++) {
         arr[i] = sc.nextLine();
         }
         */
        //System.out.println(Arrays.toString(arr));
        String[] arr = {"4", "5 9 4 7", "8", "9 13 18 10 12 4 18 3"};
        fun(arr);

    }

    private static void fun(String[] arr) {
        for (int i = 1; i < arr.length; i += 2) {
            String[] s = arr[i].split(" ");
            int[] intArr = new int[s.length];
            for (int j = 0; j < s.length; j++) {
                intArr[j] = Integer.parseInt(s[j]);
            }
            Arrays.sort(intArr);
            System.out.println(Arrays.toString(intArr));
            int sum1 = 0, sum2 = 0, controller = 1;
            for (int j = intArr.length - 1; j > 0; j -= 2) {
                if (controller % 2 == 0) {
                    sum1 += intArr[j];
                    sum2 += intArr[j - 1];
                    controller++;
                } else {
                    sum1 += intArr[j - 1];
                    sum2 += intArr[j];
                    controller++;
                }
            }
            int min = Math.min(sum1, sum2);
            int max = Math.max(sum1, sum2);
            System.out.println(min + " " + max);
        }
    }
}

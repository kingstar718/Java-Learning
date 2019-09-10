package top.wujinxing.ch_5_questions.offer.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/10 19:18
 * description
 * <p>
 * n名士兵，遇到三岔路口分为两部分，且人数差恰好为k
 * 否则在此地扎营
 * 最终扎营总数
 * <p>
 * n,k
 * 一个整数表示最终答案
 */
public class ch_9_10_2 {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();*/

        int n = 10, k = 2;
        if (n % 2 != 0) {
            System.out.println(1);
        }
    }

    private static int fun(int n, int k) {
        if (n % k != 0) {
            return 0;
        }
        return 0;
    }
}

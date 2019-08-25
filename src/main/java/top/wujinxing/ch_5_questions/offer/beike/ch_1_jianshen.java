package top.wujinxing.ch_5_questions.offer.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/23 19:36
 * description
 *
 * 越越小姐姐视卡路里为天敌,决定用S(1<=S<=10^9)元钱到健身房使用健身器材来燃烧卡路里。
 * 健身房里有n种健身器材,第i种健身器材使用费用为c[i](1<=c[i]<=10^9)，越越小姐姐想知道她最多能使用多少种器材？
 *
 * 输入
 * 第一行两个正整数n,S
 * 第二行n个正整数,第i个正整数为c[i]
 *
 * 输出
 * 一行一个整数表示最多能使用的器材数
 *
 * 样例输入
 * 5 10
 * 3 9 5 7 6
 * 样例输出
 * 2
 */
public class ch_1_jianshen {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int S = sc.nextInt();
        int[] c = new int[n];
        for (int i=0; i<n; i++){
            c[i] = sc.nextInt();
        }*/

        int n = 5;
        int S = 10;
        int[] c = {3,9,5,7,6};
        int sum = 0;
        int result = 0;
        Arrays.sort(c);
        for (int i=0; i<n; i++){
            sum += c[i];
            if (sum <= S){
                result++;
            }else {
                break;
            }
        }
        System.out.println(result);
    }
}

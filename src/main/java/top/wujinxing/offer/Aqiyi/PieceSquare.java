package top.wujinxing.offer.Aqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 牛牛有4根木棍,长度分别为a,b,c,d。
 * 羊羊家提供改变木棍长度的服务,如果牛牛支付一个硬币就可以让一根木棍的长度加一或者减一。
 * 牛牛需要用这四根木棍拼凑一个正方形出来,牛牛最少需要支付多少硬币才能让这四根木棍拼凑出正方形。
 * 输入描述:
 * 输入包括一行,四个整数a,b,c,d(1 ≤ a,b,c,d ≤ 10^6), 以空格分割
 * 输出描述:
 * 输出一个整数,表示牛牛最少需要支付的硬币
 *
 * 示例1
 * 输入
 * 4 1 5 4
 * 输出
 * 4
 */
public class PieceSquare {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            int[] a = new int[4];
            for (int i=0; i<4; i++){
                a[i] = sc.nextInt();
            }
            System.out.println(helper(a));
        }
    }
    public static int helper(int[] a){
        Arrays.sort(a);
        int mid, sum = 0;
        if(a.length%2!=0){
            mid = a[a.length/2];
        }else {
            mid = (a[a.length-1]/2)+a[a.length/2]/2;
        }
        for (int num : a){
            sum += Math.abs(mid-num);
        }
        return sum;
    }
}

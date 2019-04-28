package top.wujinxing.offer.Aqiyi;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/4/28 23:48
 * description 红和绿
 *
 * 题目描述
 * 牛牛有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。
 * 牛牛现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将会被覆盖。
 * 牛牛的目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。牛牛想知道他最少需要涂染几个正方形。
 * 如样例所示: s = RGRGR
 * 我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
 *
 * 输入描述:
 * 输入包括一个字符串s,字符串s长度length(1 ≤ length ≤ 50),其中只包括'R'或者'G',分别表示红色和绿色。
 * 输出描述:
 * 输出一个整数,表示牛牛最少需要涂染的正方形数量
 *
 * 示例1
 * 输入
 * RGRGR
 * 输出
 * 2
 */
public class RedAndGreen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int gCount = 0;
        int count  = 0;

        //在当前位置为R时有可能有两种情况， 一是把这个位置变成G， 另一种是把前面的G全变成R
        //在遍历每个字符的时候看看当前是g还是r，如果是r则需要计算一次，看看是把当前的R变成G需要的步数少还是把前面的所有G变成R步数少
        for (int i=0; i<n; i++){
            if (s.charAt(i) == 'G'){
                gCount++;
            }else {
                count = Math.min(gCount, count+1);
            }
        }
        System.out.println(count);
    }
}

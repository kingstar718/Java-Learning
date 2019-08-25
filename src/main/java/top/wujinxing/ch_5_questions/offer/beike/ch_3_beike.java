package top.wujinxing.ch_5_questions.offer.beike;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/23 20:06
 * description
 *
 * 题目描述：
 * 小明去海边游玩，他看到很多五颜六色的贝壳十分开心，于是他开始捡贝壳。
 * 小明的背包容量有限，所以他希望先捡价值大的贝壳，如果价值大的贝壳装不下了，再考虑价值次大的贝壳，
 * 直到背包再也装不下任何贝壳了。
 *
 * 现在告诉你贝壳的种类和贝壳的数量，以及小明背包的体积和每种贝壳单个占用的体积，
 * 你能算出小明的背包中最多可以装下多少个贝壳么？
 *
 * 输入
 * 第一行两个整数n,m，分别表示贝壳的种数和小明背包的体积，1≤n≤100000，1≤m≤1018；
 * 接下来n行，第i行两个整数x,y，分别表示价值第i大的贝壳的数量和单个贝壳所占的体积；1≤x≤200000，1≤y≤200000；即从上到下输入的贝壳的价值越来越小。
 * 输出
 * 一个整数，表示按要求背包中最多可以装下的贝壳的数量。
 *
 *
 * 样例输入
 * 4 100
 * 3 40
 * 3 6
 * 1 1
 * 1 5
 * 样例输出
 * 6
 */
public class ch_3_beike {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
*/
        int n = 4;
        int m = 100;
        int[][] arr = {{3,40},{3,6},{1,1},{1,5}};

        int sum = 0;
        /*for (int i=0; i<arr.length; i++){
            sum += arr[i][0];
        }*/
        for (int i=0; i<n; i++){
            if (m%arr[i][1]>=0 && m/arr[i][1]<=arr[i][0] && m>=arr[i][1]) {
                int a = m/arr[i][1];
                int b = m%arr[i][1];
                sum += a;
                m = b;
            }else if (m%arr[i][1]>=0 && m/arr[i][1]>arr[i][0] && m>=arr[i][1]){
                sum += arr[i][0];
                m = m - arr[i][0]*arr[i][0];
            }else {
                continue;
            }
        }
        System.out.println(sum);
    }
}

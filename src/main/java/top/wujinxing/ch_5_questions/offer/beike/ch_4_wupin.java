package top.wujinxing.ch_5_questions.offer.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/23 20:33
 * description 物品分堆
 *
 * 题目描述：
 * 假设有N个物品，其中第i个物品的重量为Wi。
 * 现在要将这些物品分成两堆，使得在“第一堆物品的总重量与第二堆物品的总重量之差尽可能小”的前提下，
 * 第一堆物品的数量与第二堆物品的数量之差尽可能大。
 * 那么，两堆物品的总重量之差最小是多少？在总重量之差最小的前提下，两堆物品的数量之差最大是多少？
 *
 * 输入
 * 第一行包含一个整数N，2≤N≤100。
 * 第二行包含N个空格隔开的整数W1到WN，1≤Wi≤100。
 *
 * 输出
 * 输出两个空格隔开的整数，第一个整数表示两堆物品的总重量之差的最小值，
 * 第二个整数表示在总重量之差最小的前提下，两堆物品的数量之差的最大值。
 *
 * 样例输入
 * 6
 * 1 2 3 4 5 6
 * 样例输出
 * 1 2
 */
public class ch_4_wupin {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] W = new int[N];
        for (int i=0; i<N; i++){
            W[i] = sc.nextInt();
        }*/

        int N = 6;
        int[] W = {1,2,3,4,5,6};


        Arrays.sort(W);
        int[] n = new int[N];
        for (int i=0; i<N; i++){
            n[i] = del(W, i);
            System.out.println(del(W,i));
        }

        int min = n[0];
        int minIndex=0;
        for (int i=1; i<N; i++){
            min = Math.min(min, n[i]);
        }
        for (int i=0; i<N; i++){
            if (n[i]==min){
                minIndex = i;
            }
        }
        System.out.println(minIndex);
        int minCha = Math.abs((N-minIndex-1) - (minIndex+1));
        System.out.println(min + " " + minCha);
        //System.out.println(minIndex);


    }
    private static int sum(int[] arr){
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
    private static int del(int[] arr, int index){
        int[] a = new int[index+1];
        int[] b = new int[arr.length-index-1];
        for (int i=0; i<=index; i++){
            a[i] = arr[i];
        }
        for (int i=index+1; i<arr.length; i++){
            b[i-index-1] = arr[i];
        }
        int del = sum(b)-sum(a);
        /*if (del>=0){
            return del;
        }else {
            return -1;
        }*/
        return Math.abs(del);
    }
}

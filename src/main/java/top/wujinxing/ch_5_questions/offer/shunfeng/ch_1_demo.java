package top.wujinxing.ch_5_questions.offer.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/29 19:25
 * description 学术交流
 * <p>
 * n个人参加，一直每个人获得语言
 * 一个学习机可使得一个人暂时掌握一种自己不会的语言
 * 使得任何两人都要能直接交流或者间接交流至少准备多少个学习机？
 * <p>
 * n m k 代表人数，语言数，已知的信息数
 * 接下来k行 每行两个数u v 代表第u个人会第v中语言
 * <p>
 * 输出需要准备的学习机个数
 */
public class ch_1_demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[k][2];
        for (int i=0; i<k; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        //int n = 3;
        //int m = 3;
        //int k = 2;
        //int[][] arr = {{2, 3}, {3, 1}};
        int[] sum = new int[k];
        for (int i = 0; i < k; i++) {
            sum[i] = arr[i][1];
        }
        int result = n - comSum(sum, m);
        System.out.println(result);
    }
    //计算一群人中最多会的语言数
    private static int comSum(int[] arr, int m){
        int[] a = new int[m+1];
        for (int i=0; i<arr.length; i++){
            a[arr[i]]++;
        }
        int max = a[0];
        for (int i=1; i<a.length; i++){
            if (max<a[i]){
                max = a[i];
            }
        }
        return max;
    }
}

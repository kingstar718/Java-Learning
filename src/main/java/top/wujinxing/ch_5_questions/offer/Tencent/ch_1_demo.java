package top.wujinxing.ch_5_questions.offer.Tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/1 20:05
 * description
 * <p>
 * n m 表示宝箱的数量和钥匙的数量
 * n个整数代表每个表箱上的数字
 * m个整数代表每个钥匙上的数字
 * <p>
 * 一个整数，表示最多能打开宝箱的数量
 * 数字之和为奇数代表能打开
 */
public class ch_1_demo {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] brr = new int[m];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for (int i=0; i<m; i++){
            brr[i] = sc.nextInt();
        }
        sc.close();*/
        int n = 2;
        int m = 2;
        int[] arr = {1, 2};
        int[] brr = {2, 1};
        System.out.println(fun(arr,brr,n,m));
    }

    private static int fun(int[] arr, int[] brr, int n, int m) {

        //奇数+奇数=偶数   奇数+偶数=奇数  偶数+偶数=偶数
        //分别将两个数组拆为奇数和偶数 ，最多即奇数1+偶数2 + 偶数2+奇数1
        if (n <= 0 || m <= 0)
            return 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (arr[i]%2!=0){//奇数
                list1.add(arr[i]);
            }else {
                list2.add(arr[i]);
            }
        }
        for (int i=0; i<m; i++){
            if (brr[i]%2!=0){//奇数
                list3.add(brr[i]);
            }else {
                list4.add(brr[i]);
            }
        }
        int r1 = Math.min(list1.size(), list4.size());
        int r2 = Math.min(list2.size(), list3.size());
        return r1+r2;
    }
}

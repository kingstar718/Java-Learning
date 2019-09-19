package top.wujinxing.ch_5_questions.offer.didi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/19 19:34
 * description 简单游戏
 * <p>
 * 给出一个长度为n的数组a，你需要在这个数组中找到一个长度至少为m的区间，使得这个区间内的数字的和尽可能小。
 * 输入
 * 第一行包含一个正整数n，m,表示数组的大小和所选区间的最小长度。(1<=n<100000)第二行包含n个整数，中间用空格隔开0<=|ai|<=1000。
 * 输出
 * 输出仅包含一个正整数，表示所选区间的和。
 * <p>
 * 样例输入
 * 5 3
 * 1 2 3 4 5
 * 样例输出
 * 6
 * <p>
 * 提示
 * 补充样例
 * 输入样例2
 * 5 3
 * -2 1 -1 -1 -1
 * 输出样例2
 * -4
 */
public class ch_9_19_2 {

    //45%AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(fun(arr, m));
    }

    public static int fun(int[] arr, int m) {
        if (arr == null || arr.length <= 0 || arr.length < m)
            return 0;
        int a1 = arr.length - m;
        List<Integer> list = new ArrayList<>();
        for (int i=m; i<=arr.length; i++){
            int min = sum(arr,0,i);
            for (int j=1; j+i<arr.length; j++){
                min = Math.min(min, sum(arr, j, j+i));
            }
            list.add(min);
        }
        Collections.sort(list);
        return list.get(0);
    }

    public static int sum(int[] arr, int first, int end) {
        int result = 0;
        for (int i = first; i < end; i++)
            result += arr[i];
        return result;
    }
}

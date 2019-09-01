package top.wujinxing.ch_5_questions.offer.Tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/1 20:47
 * description 搬东西
 * <p>
 * 工人：1 移动   2，搬走当前位置的东西  二选一
 * <p>
 * n m n个办公室 m个搬运工
 * n个数，表示办公室内的东西
 * <p>
 * 输出 最短时间
 */
public class ch_3_demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(Arrays.toString(arr));
    }

    private static int fun(int n, int m, int[] arr) {
        if (n <= 0 || arr == null || arr.length <= 0)
            return 0;

        int sum = 0;
        for (int i=0; i<n; i++){
            sum += arr[i];
        }
        if (sum<=m){
            return n+1;//工人比货物多，直接返回n+1
        }else {
            //工人比货物少
            int s = sum-m;
            return n+s+1;
        }
    }
}

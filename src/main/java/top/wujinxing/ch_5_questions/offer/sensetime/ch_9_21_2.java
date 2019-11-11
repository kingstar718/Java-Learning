package top.wujinxing.ch_5_questions.offer.sensetime;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/21 19:48
 * description 环形记分台
 * <p>
 * 记分台有正有负，可以从任何位置触发出发，求最大记分台
 * <p>
 * 环形数组最大积分和
 */
public class ch_9_21_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(fun(arr));
    }

    //100%AC
    private static int fun(int[] arr) {
        if (arr == null || arr.length < 1)
            return 0;
        int curMax, max, curMin, min, sum;
        curMax = max = curMin = min = sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            curMax = curMax > 0 ? curMax + arr[i] : arr[i];
            max = curMax > max ? curMax : max;
            curMin = curMin < 0 ? curMin + arr[i] : arr[i];
            min = curMin < min ? curMin : min;
        }
        if (max < 0)
            return max;
        return Math.max(sum - min, max);
    }
}

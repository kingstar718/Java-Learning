package top.wujinxing.ch_5_questions.offer.tongcheng58;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/12 20:35
 * description 分饼干
 * <p>
 * 所有孩子一条线，至少一个饼干，如果两个孩子坐一起，较高的必须多得饼干
 * <p>
 * 假如为[3,6,3,5,6,2]  饼干数量就为：[1,2,1,2,3,1]
 * 输入
 * 第一行为元素大小  后面2-n+1行为数组元素
 * 输出  可分配最小值
 */
public class ch_9_12_2 {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }*/
        int[] a1 = {3, 6, 3, 5, 6, 2};//10
        int[] a2 = {2, 4, 2, 6, 1, 7, 8, 9, 2, 1};//19
        int[] a3 = {2, 4, 2, 6, 1, 7, 8, 5, 2, 1};
        System.out.println(fun(a3, 10));
        System.out.println(fun(a1, 6));
        System.out.println(fun2(a3, 10));
    }

    //20%AC
    private static int fun(int[] arr, int n) {
        if (arr == null || arr.length <= 0)
            return 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                res[i + 1] = res[i] + 1;
            }
        }
        System.out.println(Arrays.toString(res));
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1] && res[i - 1] >= res[i]) {
                res[i - 1] = res[i] + 1;
            }
        }

        /*for (int i=0; i<n-1;i++){
            if (arr[i+1] < arr[i] && res[i+1]==res[i]){
                res[i] = res[i+1]+1;
            }
        }*/
        System.out.println(Arrays.toString(res));
        int sum = 0;
        for (int i : res
        ) {
            sum += i;
        }
        return sum;
    }

    private static int fun2(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                dp[i] = 2 * dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];

    }
}

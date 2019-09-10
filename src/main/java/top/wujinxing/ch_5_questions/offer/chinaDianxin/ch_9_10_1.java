package top.wujinxing.ch_5_questions.offer.chinaDianxin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/10 20:15
 * description
 * <p>
 * 给一个未排序的整数数组找到其中位数
 * 偶数 返回第N/2个数
 * <p>
 * 第一行一个数表示数组元素个数
 * 第二行是数组的元素
 * <p>
 * 输出中位数
 */
public class ch_9_10_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (arr == null || arr.length <= 0) {
            System.out.println(0);
        } else {
            Arrays.sort(arr);
            if (n % 2 == 0) {
                System.out.println(arr[(n / 2) - 1]);
            } else {
                System.out.println(arr[n / 2]);
            }
        }
    }
}

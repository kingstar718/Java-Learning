package top.wujinxing.ch_5_questions.offer.Tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/20 21:03
 * description 最小非零元素
 * <p>
 * 长度为n的正整数序列ai
 * 重复k轮以下操作：
 * 发现最小的非零元素x
 * 打印x
 * 把序列中所有非零元素减去x
 * <p>
 * 输入两行
 * 正整数n和k
 * n个正整数ai
 * <p>
 * 输入
 * 7 5
 * 5 8 10 3 6 10 8
 * 输出
 * 3
 * 2
 * 1
 * 2
 * 2
 */
public class ch_9_20_4 {

    //10%AC
    public static void main(String[] args) {
        /**
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int k = sc.nextInt();
         int[] arr = new int[n];
         for (int i=0; i<n; i++){
         arr[i] = sc.nextInt();
         }
         */
        int n = 7, k = 5;
        int[] arr = {5, 8, 10, 3, 6, 10, 8};
        fun(5, arr);
    }

    private static void fun(int k, int[] arr) {
        Arrays.sort(arr);
        int count =0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[arr.length - 1] >= 0) {
                int index = compI(arr);
                System.out.println(arr[index]);
                count++;
                if (count == index)
                    break;
                int result = arr[index];
                for (int j=0; j<arr.length; j++){
                    int newInt = arr[j] - result;
                    arr[j] = newInt;
                }
            }
        }
    }

    private static int compI(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                return i;
        }
        return 0;
    }
}

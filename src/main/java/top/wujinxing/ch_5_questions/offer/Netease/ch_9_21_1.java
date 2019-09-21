package top.wujinxing.ch_5_questions.offer.Netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/21 15:15
 * description 最小数位和
 * <p>
 * 定义S(n) 表示n在十进制下的各位数字和
 * 现在给定一个x，请你求出最小整数n，满足x<=S(n)
 * <p>
 * 输入：
 * 第一行数据T，对于每组数据，一行一个数字x
 * 1<=x<10^5, 1<T<10
 * <p>
 * 输出：
 * 对于每组数据，一行一个整数表示最小的n
 * <p>
 * 输入：
 * 2 表示两个数
 * 7
 * 9
 * <p>
 * 输出：
 * 7
 * 9
 * <p>
 * 输入：
 * 2
 * 13
 * 18
 * <p>
 * 输出：
 * 49
 * 99
 */
public class ch_9_21_1 {

    //30%AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = sc.nextInt();
        }
        //int[] arr = {13, 18, 23, 7, 9, 16, 30};
        fun(arr);
    }

    /**
     * 小于10的，输出原数字
     * 大于10的，先拿9减，减到小于10为止
     */
    private static void fun(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            List<Integer> list = new ArrayList<>();
            while (temp > 9) {
                temp -= 9;
                list.add(9);
            }
            list.add(temp);
            StringBuilder sb = new StringBuilder("");
            for (int j = list.size() - 1; j >= 0; j--) {
                sb.append(list.get(j));
            }
            System.out.println(Integer.parseInt(sb.toString()));
        }
    }
}

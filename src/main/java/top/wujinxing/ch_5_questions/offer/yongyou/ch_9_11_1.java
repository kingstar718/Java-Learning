package top.wujinxing.ch_5_questions.offer.yongyou;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/11 14:25
 * description 扑克游戏
 * <p>
 * 初始能量为P 初始分数为0；n张扑克牌，值以v牌面数字记
 * Joker代表20；
 * 若剩余能量P>=v 将排正面朝上，失去v点能量值，获得1分
 * 若至少有一份，可将排置为反面朝上，获得v点能量值，失去1分
 * 使用任意数量的牌后，返回我们可以得到的最大分数
 * <p>
 * 输入
 * 最大可得分数P， 扑克牌数组V
 * P=10，V=[5,8,10,13]
 * 输出
 * 最大分数，整数值
 * 2
 */
public class ch_9_11_1 {

    //100% 其实写的有问题  通不过P=10,V=[5,8,10,13]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] p1 = s.split("=");
        String P1 = p1[1].substring(0, p1[1].length() - 2);
        int P = Integer.valueOf(P1);

        int sArr = s.indexOf("[", 0);
        String s1 = s.substring(sArr + 1, s.length() - 1);
        String[] strArr = s1.split(",");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(arr);
        int temp = P;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= temp) {
                count++;
                temp -= arr[i];
            }
        }
        System.out.println(count);
    }
}

package top.wujinxing.ch_5_questions.offer.Tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/20 20:01
 * description 电话号码
 * <p>
 * 长度为n的字符串s，只包含数字，11位，且首数字必须为8
 * 每一次操作可以从中任意删除一个字符
 * 对于给定的字符串，你需要判断是否能通过0次或若干次操作，将这个字符串变成企鹅王国的电话号码
 * <p>
 * 第一行一个整数t，表示测试用例的组数；
 * 接下来2*t行，每个测试用例包含2行；
 * 第一行一个整数n，表示字符串的长度；
 * 第二行一个字符串s:
 * 输入满足1<=t<=100，1<=n<=100，每个字符串只包含数字：
 * <p>
 * 输入
 * 2
 * 11
 * 88888888888
 * 3
 * 000
 * 输出
 * YES
 * NO
 */
public class ch_9_20_1 {

    //50%AC
    public static void main(String[] args) {
        /**
         Scanner sc = new Scanner(System.in);
         int t = Integer.parseInt(sc.nextLine());
         int n = 2 * t;
         String[] arr = new String[n];
         for (int i = 0; i < n; i++) {
         arr[i] = sc.nextLine();
         }
         */
        String[] arr = {"11", "88888888888", "3", "111", "13", "1888888888888", "14", "1333333333333"};
        fun(arr);
    }

    private static void fun(String[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            if (Integer.parseInt(arr[i]) < 11) {
                System.out.println("NO");
            } else if (Integer.parseInt(arr[i]) == 11 && arr[i + 1].charAt(0)=='8') {
                System.out.println("YES");
            } else {
                String s = arr[i+1];
                for (int j=0; j<s.length(); j++){
                    int len = s.length()-j;
                    if (s.charAt(j)=='8' && len==11){
                        System.out.println("YES");
                        break;
                    }
                    if (len < 11) {
                        System.out.println("NO");
                        break;
                    }
                }
            }
        }
    }
}

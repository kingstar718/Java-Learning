package top.wujinxing.ch_5_questions.offer.chinaDianxin;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/10 20:30
 * description
 * <p>
 * 将阿拉伯数字转化为罗马数字
 * I-1  V-5   X-10   L-50  C-100   D-500  M-1000
 */
public class ch_9_10_2 {

    //80%AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);
        System.out.println(fun(n));
    }

    private static String fun(int n) {
        if (n <= 0)
            return "";
        int temp = n;
        int count;
        StringBuilder result = new StringBuilder();
        if (temp >= 1000) {
            count = temp / 1000;
            sum(result, count, "M");
            temp -= count * 1000;
        }
        if (temp >= 500) {
            result.append("D");
            temp -= 500;
        }
        if (temp >= 100) {
            count = temp / 100;
            sum(result, count, "C");
            temp -= count * 100;
        }
        if (temp >= 50) {
            result.append("L");
            temp -= 50;
        }
        if (temp >= 10) {
            count = temp / 10;
            sum(result, count, "X");
            temp -= count * 10;
        }
        if (temp >= 5) {
            result.append("V");
            temp -= 5;
        }
        sum(result, temp, "I");

        return result.toString();
    }

    private static StringBuilder sum(StringBuilder sb, int n, String s) {
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb;
    }
}

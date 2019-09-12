package top.wujinxing.ch_5_questions.offer.kedaxunfei;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/12 10:21
 * description 加法计数器
 * <p>
 * 实现一个人加法计数器  满足任意大小两个整数相加
 * <p>
 * 输入 ：两个任意大小的整数
 * 123456789987654321      987654321123456789
 * 输出：相加的结果
 * 1111111111111111110
 */
public class ch_9_12_1 {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();*/
        long a = 123456789987654321L;
        long b = 987654321123456789L;
        long c = 66987L;
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(c);
        System.out.println(fun(s1, s2));
    }

    private static Long fun(String s1, String s2) {
        if (s1 == null || s2 == null)
            return 0L;
        StringBuilder sb = new StringBuilder();
        int low = Math.min(s1.length(), s2.length());
        int high = Math.max(s1.length(), s2.length());
        //先算最后一位
        int n = Integer.parseInt(String.valueOf(s1.charAt(s1.length() - 1))) +
                Integer.parseInt(String.valueOf(s2.charAt(s2.length() - 1)));
        int count;
        if (n < 10) {
            count = 0;
            sb.append(n);
        } else {
            count = 1;
            sb.append(String.valueOf(n).charAt(1));
        }
        //计算两公共部分
        for (int i = 2; i <= low; i++) {
            n = Integer.parseInt(String.valueOf(s1.charAt(s1.length() - i))) +
                    Integer.parseInt(String.valueOf(s2.charAt(s2.length() - i))) + count;
            if (n < 10) {
                count = 0;
                sb.append(n);
            } else {
                count = 1;
                sb.append(String.valueOf(n).charAt(1));
            }
        }
        String res;
        if (s1.length() <= s2.length()) {
            res = s2;
        } else {
            res = s1;
        }
        //计算多出的部分
        for (int i = 1; i <= high - low; i++) {
            n = Integer.parseInt(String.valueOf(res.charAt(high - low - i))) + count;
            if (n >= 10) {
                sb.append(String.valueOf(n).charAt(1));
                count = 1;
            } else {
                sb.append(n);
                count = 0;
            }
        }
        //反转+取Long
        return Long.parseLong(sb.reverse().toString());
    }
}

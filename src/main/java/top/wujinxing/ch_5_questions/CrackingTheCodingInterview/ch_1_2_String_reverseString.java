package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/16 20:12
 * description 原串翻转
 * <p>
 * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
 * 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 * <p>
 * 测试样例：
 * "This is nowcoder"
 * 返回："redocwon si sihT"
 */
public class ch_1_2_String_reverseString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseString(s));
        System.out.println(reverseString2(s));
        System.out.println(reverseString3(s));
    }

    //还是new了个字符数组
    private static String reverseString(String iniString) {
        char[] c = iniString.toCharArray();
        for (int i = 0; i < c.length >> 1; i++) {
            char temp = c[c.length - 1 - i];
            c[c.length - 1 - i] = c[i];
            c[i] = temp;
        }
        return String.valueOf(c);
    }

    private static String reverseString2(String iniString) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < iniString.length(); i++) {
            char c = iniString.charAt(iniString.length() - 1 - i);
            newStr.append(c);
        }
        return newStr.toString();
    }

    private static String reverseString3(String iniString) {
        StringBuilder newStr = new StringBuilder(iniString);
        return newStr.reverse().toString();
    }
}

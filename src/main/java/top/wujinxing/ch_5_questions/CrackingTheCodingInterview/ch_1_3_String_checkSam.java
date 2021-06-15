package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/16 20:38
 * description 确定两串乱序重构
 * <p>
 * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 这里规定大小写为不同字符，且考虑字符串中的空格。
 * 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
 * <p>
 * 测试样例：
 * "This is nowcoder","is This nowcoder"
 * 返回：true
 * "Here you are","Are you here"
 * 返回：false
 */
public class ch_1_3_String_checkSam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(checkSam(s1, s2));
    }

    private static boolean checkSam(String stringA, String stringB) {
        if (stringA.length() == 0 || stringB.length() == 0 || stringA.length() != stringB.length()) return false;

        int len = stringA.length();
        int[] strA = new int[256];
        int[] strB = new int[256];

        for (int i = 0; i < len; i++) {
            //利用各个字符的ASCII编码不同的方法，出现一次数组就加一
            strA[stringA.charAt(i)]++;
            strB[stringB.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (strA[i] != strB[i]) return false;
        }
        return true;
    }
}

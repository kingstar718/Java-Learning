package top.wujinxing.cracking_the_coding_interview;

import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/8/16 19:59
 * description 确定字符串互异
 * <p>
 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 * 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。
 * 保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 * <p>
 * 测试样例：
 * "aeiou"
 * 返回：True
 * "BarackObama"
 * 返回：False
 */
public class ch_1_1_String_checkDifferent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(func(s));
    }

    private static boolean func(String s) {
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(j) == s.charAt(i)) return false;
            }
        }
        return true;
    }
}

package top.wujinxing.ch_5_questions.SwordOffer;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujinxing
 * date 2019 2019/9/12 14:37
 * description 左旋字符串
 * <p>
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列`S=”abcXYZdef”`,
 * 要求输出**循环左移3位**后的结果，即`“XYZdefabc”`。是不是很简单？OK，搞定它！
 */
public class ch_43_LeftRotateString {

    public String LeftRotateString(String str, int n) {
        if (str.length() <= 0)
            return "";
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            queue.add(str.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            char c = queue.poll();
            queue.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : queue) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 将字符串分成两部分，第一部分记为前n个字符部分记为`A`，后面的部分记为`B`；
     * 其实这个题目就是要你从`AB`转换到`BA`；
     * 做法就是 (1)、先将A部分字符串翻转；(2)、然后将B字符串翻转；(3)、最后将整个字符串翻转；
     * 也就是(A<sup>T</sup>B<sup>T</sup>)<sup>T </sup>= BA；
     */
    public String LeftRotateString2(String str, int n) {
        if (str == null || str.length() == 0) return "";
        if (n == str.length() || n == 0)
            return str;
        char[] chs = str.toCharArray();
        reverse(chs, 0, n - 1);
        reverse(chs, n, str.length() - 1);
        reverse(chs, 0, str.length() - 1);
        return new String(chs);
    }

    private void reverse(char[] chs, int L, int R) {
        for (; L < R; L++, R--) {
            char c = chs[L];
            chs[L] = chs[R];
            chs[R] = c;
        }
    }

    @Test
    public void test() {
        String s = "XYZdefabc";
        System.out.println(LeftRotateString(s, 3));
        System.out.println(LeftRotateString2(s, 3));
    }
}

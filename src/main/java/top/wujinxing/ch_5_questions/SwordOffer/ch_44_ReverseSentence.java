package top.wujinxing.ch_5_questions.SwordOffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wujinxing
 * date 2019 2019/9/12 19:31
 * description
 * <p>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串`"I am a student. "`，则输出`"student. a am I"`。
 */
public class ch_44_ReverseSentence {

    public String ReverseSentence(String str) {
        if (str.trim().equals(" ")) return str;
        int n = str.length();
        char[] chs = str.toCharArray();
        // 1、先翻转整个字符串
        reverse(chs, 0, n - 1);
        for (int i = 0; i < n; ) {// 2、然后翻转其中的每一个单词
            while (i < n && chs[i] == ' ') i++;
            int L = i, R = i;
            for (; i < n && chs[i] != ' '; i++, R++) ;
            reverse(chs, L, R - 1);
        }
        return new String(chs);
    }

    //翻转chs在[L, R]范围内的字符
    private void reverse(char[] chs, int L, int R) {
        for (; L < R; L++, R--) {
            char c = chs[L];
            chs[L] = chs[R];
            chs[R] = c;
        }
    }

    public String ReverseSentence2(String str) {
        if (str.trim().equals(" ")) return str;// 注意"    "这种空格多的情况

        StringBuilder sb = new StringBuilder();
        String[] strings = str.split(" ");
        for (int i = strings.length - 1; i > 0; i--) {
            sb.append(strings[i]).append(" ");
        }
        sb.append(strings[0]);
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "I am a student. ";
        System.out.println(ReverseSentence(s));
        System.out.println(ReverseSentence2(s));
    }
}

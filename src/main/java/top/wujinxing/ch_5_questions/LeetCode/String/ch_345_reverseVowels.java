package top.wujinxing.ch_5_questions.LeetCode.String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/9/26 18:44
 * description 反转字符串中的元音字母
 */
public class ch_345_reverseVowels {

    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        int length = s.length();
        int head = 0;
        int tail = length - 1;
        char temp;

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        while (head < tail) {
            //滑动窗口，都找到 即交换
            if (vowels.contains(s.charAt(head)) == true && vowels.contains(s.charAt(tail)) == true) {
                temp = s.charAt(head);
                sb.setCharAt(head, s.charAt(tail));
                sb.setCharAt(tail, temp);
                head++;
                tail--;
            } else if (vowels.contains(s.charAt(head)) == true && vowels.contains(s.charAt(tail)) != true) {
                tail--;
            } else if (vowels.contains(s.charAt(head)) != true && vowels.contains(s.charAt(tail)) == true) {
                head++;
            } else {
                head++;
                tail--;
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }
}

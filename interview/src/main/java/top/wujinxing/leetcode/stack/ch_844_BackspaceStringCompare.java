package top.wujinxing.leetcode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/12/31 21:03
 * description 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * 提示：
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 */
public class ch_844_BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#')
                stack.push(c);
            else if (!stack.empty())
                stack.pop();
        }
        return String.valueOf(stack);
    }

    @Test
    public void test(){
        String s1 = "a##c";
        String s2 = "#a#c";
        String s3 = "a#c";
        String s4 = "b";
        System.out.println(backspaceCompare(s1, s2));
        System.out.println(backspaceCompare(s3, s4));
    }
}

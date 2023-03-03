package top.wujinxing.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujinxing
 * @date 2023/3/4
 * <p>
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */
public class Ch1047RemoveAllAdjacentDuplicatesInString {

    /**
     * 遍历字符，如果字符和栈顶元素匹配，就把栈顶元素出栈。
     * 如果不匹配，就把元素入栈。
     * 这样一来，栈里最后剩下的都是相邻不相同的元素。
     * 最后出栈的元素需要倒转
     */
    public static String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty() || !stack.peek().equals(c)) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}

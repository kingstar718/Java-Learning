package top.wujinxing.leetcode.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author wujinxing
 * @date 2019 2019/12/31 16:10
 * <p>
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 */
public class Ch20ValidParentheses {

    private HashMap<Character, Character> mappings;

    public Ch20ValidParentheses() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put(']', '[');
        this.mappings.put('}', '{');
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        // 采取对应一对就删除一对的方法
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 先判断字符是否是括号中的后半部分，不是则直接压栈
            if (mappings.containsKey(c)) {
                // 当前c若是后半括号，则栈中若不是为空，则取出栈顶
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                // 若取出的元素与mapping中不对应，则表示不是一对
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 方法很取巧，因为知道优先情况
     */
    public boolean isValid2(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if ((stack.isEmpty() || stack.pop() != c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}

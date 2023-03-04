package top.wujinxing.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujinxing
 * @date 2023/3/4
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 */
public class Ch150EvaluateReversePolishNotation {

    /**
     * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if ("+".equals(s)) {
                    stack.push(num1 + num2);
                } else if ("-".equals(s)) {
                    stack.push(num1 - num2);
                } else if ("*".equals(s)) {
                    stack.push(num1 * num2);
                } else if ("/".equals(s)) {
                    stack.push(num2 / num1);
                }
            }
        }
        return stack.pop();
    }

    public static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

}

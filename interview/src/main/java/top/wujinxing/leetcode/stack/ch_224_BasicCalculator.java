package top.wujinxing.leetcode.stack;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author wujinxing
 * date 2019 2019/12/31 21:27
 * description 基本计算器
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 示例 1:
 * 输入: "1 + 1"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * <p>
 * 示例 3:
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 */
public class ch_224_BasicCalculator {

    public int calculate(String s) {
        LinkedList<Boolean> stack = new LinkedList<>();
        int result = 0, opr = 0;
        Character op = null;
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                if (op == null) {
                    result = opr;
                } else {
                    result = cal(op, result, opr);
                }
                op = swap(stack.peek() == null ? false : stack.peek(), c);
                opr = 0;
            } else if (c == '(') {
                stack.push(op != null && op == '-');
            } else if (c == ')') {
                stack.pop();
            } else if (c != ' ') {
                opr = opr * 10 + c - '0';
            }
        }

        if (op == null){
            return opr;
        }else {
            return cal(op, result, opr);
        }
    }

    char swap(boolean swap, char c) {
        if (swap) {
            return c == '+' ? '-' : '+';
        } else {
            return c;
        }
    }

    private int cal(char op, int opr1, int opr2) {
        switch (op) {
            case '+':
                return opr1 + opr2;
            case '-':
                return opr1 - opr2;
            default:
                return 0;
        }
    }

    @Test
    public void test(){
        String s1 = "(1+(4+5+2)-3)+(6+8)";
        String s2 = " 2-1 + 2 ";
        System.out.println(calculate(s1));
        System.out.println(calculate(s2));
    }

}

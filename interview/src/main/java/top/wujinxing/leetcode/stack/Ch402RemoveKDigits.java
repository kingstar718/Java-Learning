package top.wujinxing.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujinxing
 * @date 2023/3/7
 * <p>
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，
 * 使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 */
public class Ch402RemoveKDigits {

    public static String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Deque<Character> stack = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && count < k) {
                stack.pop();
                count++;
            }
            if (num.charAt(i) == '0' && stack.isEmpty()) {
                continue;
            }
            stack.push(num.charAt(i));
        }
        while (!stack.isEmpty() && count < k) {
            stack.pop();
            count++;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * 双端队列
     */
    public static String removeKdigits2(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();

        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        final StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

package top.wujinxing.cracking_the_coding_interview;

import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/8/21 21:24
 * description 合法括号序列判断
 *
 * 题目描述
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 *
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 *
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 */
public class ch_9_6_chkParenthesis {

    public static void main(String[] args) {
        String A1 = "()()(()())";
        String A2 = "()()((()())";
        System.out.println(chkParenthesis(A1, A1.length()));
        System.out.println(chkParenthesis(A2, A2.length()));
    }

    private static boolean chkParenthesis(String A, int n) {
        /**
         * 1.碰到“）”开始弹出栈顶的“（”，如果此时栈为空。则返回false
         * 2.碰到其他内容直接返回false
         * 3.字符串结尾时，栈非空返回false
         */
        Stack<Character> lefts = new Stack<>();
        if (A==null||A.length()!=n) return false;

        for (int i=0; i<n; i++){
            if (A.charAt(i)=='('){
                lefts.push(A.charAt(i));
            }else if (A.charAt(i)==')'){
                if (lefts.isEmpty()){
                    return false;
                }else {
                    lefts.pop();
                }
            }else {
                return false;
            }
        }
        if (!lefts.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}

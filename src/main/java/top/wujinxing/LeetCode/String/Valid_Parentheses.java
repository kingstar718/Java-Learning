package top.wujinxing.LeetCode.String;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: wujinxing
 * @date: 2019/2/27 09:18
 * @description:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:           Example 2:          Example 3:      Example 4:
 *
 * Input: "()"          Input: "()[]{}"     Input: "(]"     Input: "([)]"
 * Output: true         Output: true        Output: false   Output: false
 *
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class Valid_Parentheses {
    private HashMap<Character, Character> mappings;

    public Valid_Parentheses(){
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')','(');
        this.mappings.put('}','{');
        this.mappings.put(']','[');
    }

   /*       Stack的api回忆
            boolean	empty()     测试此堆栈是否为空。
            E	peek()      查看此堆栈顶部的对象，而不将其从堆栈中删除。
            E	pop()       移除此堆栈顶部的对象，并将该对象作为此函数的值返回。
            E	push(E item)    将项目推到此堆栈的顶部。
            int	search(Object o)    返回对象在此堆栈上的从1开始的位置。
    */

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //判断是否包含指定的键值containsKey
            // 先判断（ { [ 是否在HashMap的key里
            if (this.mappings.containsKey(c)){
                //获取栈的顶部元素，如果栈为空，则设置虚拟值#
                char topElement = stack.empty() ? '#' : stack.pop();
                //返回指定键映射到的值get
                //如果此括号的映射与栈的top元素不匹配，返回false
                if (topElement != this.mappings.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()
             ) {
            if (c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        String s1 = "(){}[]";
        String s2 = "(){}[]]";
        String s3 = "({[]})";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid2(s1));
        System.out.println(isValid2(s2));
        System.out.println(isValid2(s3));
    }
}

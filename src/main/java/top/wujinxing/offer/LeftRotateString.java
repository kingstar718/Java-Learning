package top.wujinxing.offer;

import org.junit.Test;

/**
 * @ author: wujinxing
 * @ date: 2019/4/4 09:27
 * @ description: 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    public String LeftRotateStringTest(String str, int n) {
        if (str == null || n < 0 || n > str.length()) {
            return null;
        }
        StringBuffer sb = new StringBuffer(str);
        sb.append(sb.substring(0, n));
        return sb.substring(n, sb.length());
    }

    public String LeftRotateStringTestTwo(String str, int n){
        char[] chars =str.toCharArray();
        if (chars.length<n){
            return "";
        }
        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length-1);

        return new String(chars);

    }

    private void reverse(char[] chars, int start, int end){
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] =temp;
            start++;
            end--;
        }
    }

    @Test
    public void test(){
        String a = "abcXYZdef";
        int n = 3;
        System.out.println(LeftRotateStringTest(a, n));
        System.out.println(LeftRotateStringTestTwo(a, n));
    }
}

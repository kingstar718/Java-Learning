package top.wujinxing.leetcode.array;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/4/9 09:31
 * @description: 计算一组字符集合可以组成的回文字符串的最大长度
 */
public class longestPalindrome_409 {
    public int longestPalindrome(String s){
        int[] cnts = new int[256];
        for (char c : s.toCharArray()){
            cnts[c]++; //计算字符的重复次数
        }
        int palindrome = 0;
        for (int cnt : cnts){
            palindrome += (cnt/2)*2;
        }
        if (palindrome < s.length()){
            palindrome++;
        }
        return palindrome;
    }

    @Test
    public void test(){
        System.out.println(longestPalindrome("abccccdd"));
    }
}

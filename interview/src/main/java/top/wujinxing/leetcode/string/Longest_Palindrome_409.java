package top.wujinxing.leetcode.string;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/3/9 20:14
 * @description:
 * Input : "abccccdd"
 * Output : 7
 * Explanation : One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 使用长度为 256 的整型数组来统计每个字符出现的个数，每个字符有偶数个可以用来构成回文字符串。
 *
 * 因为回文字符串最中间的那个字符可以单独出现，所以如果有单独的字符就把它放到最中间。
 */
public class Longest_Palindrome_409 {

    public int longestPalindrome(String s){
        int[] cnts = new int[256];
        for (char c : s.toCharArray()){
            cnts[c]++;
        }

        int palindrome = 0;
        for (int cnt : cnts){
            palindrome += (cnt/2)*2;
        }
        if (palindrome < s.length()){//这个条件下s中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
            palindrome++;
        }
        return palindrome;
    }

    @Test
    public void test(){
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}

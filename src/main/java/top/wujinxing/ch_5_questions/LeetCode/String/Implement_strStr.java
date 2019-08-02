package top.wujinxing.ch_5_questions.LeetCode.String;

/**
 * @author: wujinxing
 * @date: 2019/3/2 15:29
 * @description:
 * Implement strStr(). *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1: *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2: *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */

import org.junit.Test;

/**
 * 返回haystack中第一次出现needle的索引，如果没有返回-1
 */
public class Implement_strStr {
    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle){
        for (int i = 0; ; i++){
            for (int j = 0; ; j++){
                if (j == needle.length()) return i;
                if (i+j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i+j)) break;
            }
        }
    }

    @Test
    public void test(){
        String a = "hello";
        String b = "ll";
        System.out.println(strStr1(a,b));
        System.out.println(strStr2(a,b));
    }
}

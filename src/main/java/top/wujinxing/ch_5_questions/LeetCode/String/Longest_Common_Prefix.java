package top.wujinxing.ch_5_questions.LeetCode.String;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/3/1 17:45
 * @description:    输出所有字符串中相同的字符串
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        //
        for(int i = 0; i < strs.length; i++)
            //匹配
            //int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
            while(strs[i].indexOf(prefix) != 0){
                //新的prefix为两个字符串中所共有的字符串
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        return prefix;
    }

    @Test
    public void test(){
        String[] a = {"flower","flow","flight"};
        String[] b = {"dog","racecar","car"};
        String[] c = {"leets","leetcode","leet","leeds"};
        System.out.println(longestCommonPrefix(a));
        System.out.println(longestCommonPrefix(b));
        System.out.println(longestCommonPrefix(c));
    }
}

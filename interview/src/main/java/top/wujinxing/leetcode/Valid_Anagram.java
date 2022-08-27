package top.wujinxing.leetcode;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/3/4 09:49
 * @description:
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for(int count : counter){
            if(count != 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        String a = "anagram";
        String b = "nagrama";
        System.out.println(isAnagram(a,b));
    }
}

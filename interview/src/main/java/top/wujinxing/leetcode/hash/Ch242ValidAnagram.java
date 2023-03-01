package top.wujinxing.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujinxing
 * @date 2023-03-01
 */
public class Ch242ValidAnagram {

    /**
     * 给定两个字符串s和t，编写一个函数来判断t是否是s的字母异位词
     * 注意：若s和t中每个字符出现的次数都相同，则称s和t互为字母异位词
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final char sChar = s.charAt(i);
            final char tChar = t.charAt(i);
            map.put(sChar, map.getOrDefault(sChar, 0) + 1);
            map.put(tChar, map.getOrDefault(tChar, 0) - 1);
        }
        for (Integer v : map.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}

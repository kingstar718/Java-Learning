package top.wujinxing.LeetCode.String;

import java.util.HashMap;

/**
 * @author: wujinxing
 * @date: 2019/2/26 20:17
 * @description:
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 */
public class First_Unique_Character_in_a_String {
    public static int firstUniqueChar(String s){
        HashMap<Character, Integer> count = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < n; i++){
            if (count.get(s.charAt(i)) == 1){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args){
        String s = "leetcode";
        String s2 = "loveleetcode";

        System.out.println(firstUniqueChar(s));
        System.out.println(firstUniqueChar(s2));
    }

}

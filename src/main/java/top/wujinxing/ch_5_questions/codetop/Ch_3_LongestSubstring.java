package top.wujinxing.ch_5_questions.codetop;


import java.util.HashSet;

/**
 * @author /
 * @date 2021-12-20
 */
public class Ch_3_LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < l; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一格字符
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < l && !set.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}

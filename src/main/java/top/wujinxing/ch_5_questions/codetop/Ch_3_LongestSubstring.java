package top.wujinxing.ch_5_questions.codetop;


import java.util.HashSet;
import java.util.Set;

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

    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int rk = 0;
        int result = 0;
        for (int i = 0; i < len; ++i) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk < len && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                ++rk;
            }
            result = Math.max(result, rk - i);
        }
        return result;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int[] last = new int[128];
        for (int i = 0; i < 128; ++i) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        // 窗口开始位置
        int start = 0;
        for (int i = 0; i < n; ++i) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3("bbbbb"));
        System.out.println(lengthOfLongestSubstring3("pwwkew"));
    }
}

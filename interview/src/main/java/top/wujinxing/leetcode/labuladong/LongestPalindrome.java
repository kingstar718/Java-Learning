package top.wujinxing.leetcode.labuladong;


/**
 * [5] 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * @author wujinxing
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以s[i]为中心的最长回文字符串
            String s1 = palindrome(s, i, i);
            // 以s[i]和s[i+1]为中心的最长回文子串
            String s2 = palindrome(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private static String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以s[l]和s[r]为中心的最长回文串
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
        s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

}
package top.wujinxing.ch_5_questions.LeetCode.DynamicProgramming;

import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/8/22 14:22
 * description
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *给定非空字符串s和包含非空字列表的字典wordDict，确定s是否可以被分段为一个或多个字典单词的空格分隔序列。
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 字典中的相同单词可以在分段中多次重复使用。
 * 您可能认为字典不包含重复的单词。
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class _139_Word_Break {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) return true;
        if (wordDict == null) return false;

        StringBuffer sb = new StringBuffer(s);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i=0; i<sb.length(); i++){
            for (int j=0; j<i; j++){
                if (dp[j] && wordDict.contains(sb.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

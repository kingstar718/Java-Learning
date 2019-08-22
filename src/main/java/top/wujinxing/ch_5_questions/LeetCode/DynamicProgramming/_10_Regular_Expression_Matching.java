package top.wujinxing.ch_5_questions.LeetCode.DynamicProgramming;

/**
 * @author wujinxing
 * date 2019 2019/8/22 10:06
 * description
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class _10_Regular_Expression_Matching {

    private int[][] dp;

    // s只有字符， p可以有.和*, .匹配单个任意字符，'*'匹配多个任意字符
    public boolean isMatch(String s, String p) {
        dp = new int[s.length()+1][p.length()+1];
        return match(s.toCharArray(), p.toCharArray(), s.length(), p.length());
    }

    // ls代表当前s的长度， lp代表当前p的长度
    public boolean match(char[] s, char[] p, int ls, int lp){
        if (ls == 0 && lp == 0) return true;
        if (dp[ls][lp] != 0) return dp[ls][lp] == 1;
        if (lp == 0) return false;
        boolean res = false;
        if (ls == 0){  //ls为空
            res = lp >= 2 && p[lp-1] == '*' && match(s, p, ls, lp - 2);
        }else {
            if (p[lp-1] == '.' || s[ls-1] == p[lp-1]){
                return match(s, p, ls-1, lp-1);
            }else if (p[lp-1] == '*'){
                if (p[lp-2] == '.'){
                    res = match(s, p, ls-1, lp-1)
                            ||match(s, p, ls-1, lp)
                            ||match(s, p, ls, lp-2);
                }else if (s[ls-1]==p[lp-2]){
                    res = match(s, p, ls-1, lp-2)   //这里和上面不同，不是ls-1, lp-1,
                            ||match(s, p, ls-1, lp)
                            ||match(s, p, ls, lp-2);
                }else { // 只能丢掉 p[pl-1]和p[pl-2]
                    res = match(s, p, ls, lp-2);
                }
            }
        }
        dp[ls][lp] = res ? 1 : -1;
        return res;
    }

    private boolean match(char[] s, char[] p){
        int ls = s.length;
        int lp = p.length;
        boolean[][] dp = new boolean[ls+1][lp+1];
        dp[0][0] = true;

        for (int i=1; i<=lp; i++) {
            if (p[i-1]=='*') dp[0][i] = dp[0][i-2];
        }

        for (int i=1; i<=ls; i++){
            for (int j=1; j<=lp; j++){
                if (s[i-1]==p[j-1] || p[j-1]=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p[j-1] == '*'){
                    if (p[j - 2] == '.') {
                        dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-2];
                    }else if (s[i-1] == p[j-2]) {
                        dp[i][j] = dp[i-1][j-2] || dp[i-1][j] || dp[i][j-2];
                    }else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[ls][lp];
    }
}

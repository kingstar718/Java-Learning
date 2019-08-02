package top.wujinxing.ch_5_questions.LeetCode.Array;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/4/9 10:02
 * @description: 统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数
 * Example 1:
 *  *
 *  * Input: "00110011"
 *  * Output: 6
 *  * Explanation: There are 6 substrings that have equal number of consecutive
 *  * 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 *  * Notice that some of these substrings repeat and are counted the number of
 *  * times they occur.
 *  * Also, "00110011" is not a valid substring because all the 0's (and 1's) are
 *  * not grouped together.
 *  *
 *  *
 *  *
 *  * Example 2:
 *  *
 *  * Input: "10101"
 *  * Output: 4
 *  * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal
 *  * number of consecutive 1's and 0's.
 */
public class Count_Binary_Substrings_696 {
    public int countBinarySubstrings(String s) {
        int preLen = 0, cuLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cuLen++;
            } else {
                preLen = cuLen;
                cuLen = 1;
            }

            if (preLen >= cuLen) {
                count++;
            }
        }
        return count;
    }
    @Test
    public void test(){
        System.out.println(countBinarySubstrings("00110"));
        System.out.println(countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings("10101"));
    }
}

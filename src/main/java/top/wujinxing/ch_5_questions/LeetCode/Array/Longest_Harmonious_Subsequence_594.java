package top.wujinxing.ch_5_questions.LeetCode.Array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wujinxing
 * @date: 2019/4/10 10:10
 * @description: 最长和谐序列
 *
 * 和谐序列中最大数和最小数之差正好为 1，应该注意的是序列的元素不一定是数组的连续元素。
 *
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 */
public class Longest_Harmonious_Subsequence_594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        //key存数字  value存该数字在list里出现了几次
        int longest = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }

    @Test
    public void test(){
        int[] a = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(a));
    }
}

package top.wujinxing.ch_5_questions.LeetCode.Array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wujinxing
 * @date: 2019/4/10 10:34
 * @description: 最长连续序列
 *
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * copy to clipboardErrorCopied
 *
 * 要求以 O(N) 的时间复杂度求解。
 */
public class Longest_Consecutive_Sequence_128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, 1);
        }
        for (int num : nums) {
            forward(countForNum, num);
        }
        return maxCount(countForNum);
    }

    private int forward(Map<Integer, Integer> countForNum, int num) {
        if (!countForNum.containsKey(num)) {
            return 0;
        }
        int cnt = countForNum.get(num);
        if (cnt > 1) {
            return cnt;
        }
        cnt = forward(countForNum, num + 1) + 1;
        countForNum.put(num, cnt);
        return cnt;
    }

    private int maxCount(Map<Integer, Integer> countForNum) {
        int max = 0;
        for (int num : countForNum.keySet()) {
            max = Math.max(max, countForNum.get(num));
        }
        return max;
    }

    @Test
    public void test(){
        int[] a = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(a));
    }
}

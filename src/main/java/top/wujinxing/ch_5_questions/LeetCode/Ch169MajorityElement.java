package top.wujinxing.ch_5_questions.LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wujinxing
 * @date 2021/1/17
 * @description
 */
public class Ch169MajorityElement {

    @Test
    public void test() {
        int[] a = {3,2,3};
        int[] b = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(a));
        System.out.println(majorityElement(b));
        System.out.println(majorityElement2(b));
        System.out.println(majorityElement2(b));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> entry = null;
        for (Map.Entry<Integer, Integer> e: counts.entrySet()) {
            if (entry == null || e.getValue() > entry.getValue()) {
                entry = e;
            }
        }
        return entry.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map;
    }
}

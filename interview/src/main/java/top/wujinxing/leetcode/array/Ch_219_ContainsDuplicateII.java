package top.wujinxing.leetcode.array;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 链接：<a href="https://leetcode.cn/problems/contains-duplicate-ii/">Contains Duplicate II</a>
 * <p>
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 */
public class Ch_219_ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(containsNearByDuplicate(nums1, 3));
        System.out.println(containsNearByDuplicate2(nums1, 3));
    }

    private static boolean containsNearByDuplicate(int[] nums, int k) {
        final HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    private static boolean containsNearByDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}

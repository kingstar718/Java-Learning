package top.wujinxing.leetcode.array;

import java.util.HashSet;

public class Ch_Sword_03_findRepeatNumber {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
        System.out.println(findRepeatNumber2(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        final HashSet<Integer> set = new HashSet<>();
        for (final int curr : nums) {
            if (set.contains(curr)) {
                return curr;
            }
            set.add(curr);
        }
        return 0;
    }

    public static int findRepeatNumber2(int[] nums) {
        final int length = nums.length;
        if (length == 0) {
            return -1;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                int index = nums[i];
                if (nums[index] == nums[i]) {
                    return index;
                }
                // 交换位置
                //int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = index;
            }
        }
        return -1;
    }
}

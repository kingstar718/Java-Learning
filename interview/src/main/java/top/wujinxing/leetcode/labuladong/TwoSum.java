package top.wujinxing.leetcode.labuladong;


import java.util.Arrays;

/**
 * 两数之和 II - 输入有序数组
 *
 * @author wujinxing
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // 题目要求的索引是从1开始的
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
        System.out.println(Arrays.toString(twoSum(numbers, 18)));
        System.out.println(Arrays.toString(twoSum(numbers, 26)));
    }

}

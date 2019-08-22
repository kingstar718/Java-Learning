package top.wujinxing.ch_5_questions.LeetCode.DynamicProgramming;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/8/22 19:06
 * description
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *给定整数数组nums，找到具有最大乘积的数组（包含至少一个数字）内的连续子数组。
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */
public class _152_Maximum_Product_Subarray {

    /**
     * 一维DP
     * 使用一个一维数组记录每个位置结尾的最大累乘积， 再使用一个变量（记录结果）
     * 记录每个位置结尾end[i]的最大值
     * 如何快速求出所有以i位置结尾（nums[i]）的子数组的最大累乘积？
     * 假设以nums[i-1]结尾的最大累乘积为maxEnds[i-1]，以nums[i-1]记为的最小累乘积为minEnds[i-1]，
     * 那么以nums[i]结尾的最大累乘积只有三种可能
     *
     * 可能是 maxEnds[i-1] * nums[i]，这个是显然的，因为记录前面的最大值，如[3,4,5]；
     * 可能是 minEnds[i-1] * nums[i]，因为minEnds[i-1]和nums[i]都有可能是负数，如[-2,-4]；
     * 也有可能是nums[i]自己；
     */
    public int maxProduct(int[] nums) {
        if (nums==null||nums.length<=0) return 0;

        int[] minEnds = new int[nums.length];
        int[] maxEnds = new int[nums.length];
        maxEnds[0] = minEnds[0] = nums[0];  //初始的最大值最小值都等于第一个数
        int res = nums[0]; //记录结果

        for (int i=1; i<nums.length; i++){
            int max = nums[i]*maxEnds[i-1];  //前0-i位的数组最大值计算， 可能为负数
            int min = nums[i]*minEnds[i-1];
            maxEnds[i] = Math.max(max, Math.max(min, nums[i]));
            minEnds[i] = Math.min(min, Math.min(max, nums[i]));
            res = Math.max(maxEnds[i], res);
        }
        return res;
    }


    @Test
    public void test(){
        int[] array1= {2,3,-2,4};
        int[] array2= {-2,0,-1};
        System.out.println(maxProduct(array1));
        System.out.println(maxProduct(array2));
    }
}

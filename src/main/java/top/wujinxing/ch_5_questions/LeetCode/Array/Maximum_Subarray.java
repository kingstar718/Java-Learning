package top.wujinxing.ch_5_questions.LeetCode.Array;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/2/25 21:02
 * @description:
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int l = nums.length;
        int[] n = new int[l];

        n[0] = nums[0];
        int max = n[0];

        for(int i = 1; i < l; i++){
            n[i] = nums[i] + (n[i-1] > 0 ? n[i-1] : 0); //true返回前面，false返回后面
            max = Math.max(max, n[i]);
        }
        return max;
    }

    /**
     * 比较前后两个元素，前一个元素不为负，将前后两个元素相加作为后元素
     * 比较两个元素大小，留下大的
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums){
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] > 0){
                nums[i] += nums[i-1];
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    @Test
    public void test(){
        int[] n = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(n));
        System.out.println(maxSubArray2(n));
    }
}

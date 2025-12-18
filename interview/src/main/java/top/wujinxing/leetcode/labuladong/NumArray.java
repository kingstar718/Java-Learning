package top.wujinxing.leetcode.labuladong;


/**
 * 给定一个整数数组 nums，计算索引left和right（包含left和right）之间的 nums 元素的和 ，其中left <= right
 *
 * @author wujinxing
 */
public class NumArray {

    private final int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
    }

}


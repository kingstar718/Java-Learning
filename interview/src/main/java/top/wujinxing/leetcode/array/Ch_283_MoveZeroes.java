package top.wujinxing.leetcode.array;

import java.util.Arrays;

/**
 * @author wujinxing
 * @date 2022-03-26
 * @link https://leetcode-cn.com/problems/move-zeroes/description
 */
public class Ch_283_MoveZeroes {

    /**
     * 不为0的，往前移，后边补0即可
     */
    public static void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {0,2,4,7,0,9,4,6,0,22,9,8,2,0,0,0,2,9};
        System.out.println(Arrays.toString(a1));
        moveZeroes(a1);
        System.out.println(Arrays.toString(a1));
    }
}

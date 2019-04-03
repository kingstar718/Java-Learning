package top.wujinxing.LeetCode.Array;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/2/25 20:27
 * @description:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * * Example:
 * * Given nums = [2, 7, 11, 15], target = 9,
 * * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Two_Sum {
    //自己写的
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if((nums[j]+nums[i]) == target){
                    a[0] = i;
                    a[1] = j;
                }
            }
        }
        return a;
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    @Test
    public void test(){
        int[] a = {2,7,11,15}; //9
        int[] b = {-18,12,3,24,0}; //6
        int[] s = twoSum(a,9);
        int[] m = twoSum(b,6);
        System.out.println(s[0] + " " + s[1]);
        System.out.println(m[0] + " " + m[1]);

        int[] s2 = twoSum2(a,9);
        int[] m2 = twoSum2(b,6);
        System.out.println(s2[0] + " " + s2[1]);
        System.out.println(m2[0] + " " + m2[1]);
    }
}

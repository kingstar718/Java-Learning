package top.wujinxing.ch_5_questions.LeetCode.Array;

import org.junit.Test;

import java.util.HashMap;

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

    public int[] twoSum3(int[] nums, int target){
        // HashMap 存储数组元素和索引的映射
        HashMap<Integer, Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            //在访问到 nums[i] 时，判断 HashMap 中是否存在 target - nums[i]，
            if (indexForNum.containsKey(target - nums[i])){
                //如果存在说明 target - nums[i] 所在的索引和 i 就是要找的两个数。
                // 该方法的时间复杂度为 O(N)，空间复杂度为 O(N)，使用空间来换取时间。
                return new int[]{indexForNum.get(target - nums[i]), i};
            }else {
                indexForNum.put(nums[i], i);
            }
        }
        return null;
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

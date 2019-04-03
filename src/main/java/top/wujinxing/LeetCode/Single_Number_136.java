package top.wujinxing.LeetCode;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/3/4 09:30
 * @description:    输出一个列表里唯一一个不重复的元素
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1: *
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2: *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class Single_Number_136 {
    public int singleNumber(int[] nums){
        int result = 0;
        for (int i : nums){
            //result = reault^i;
            //^符号是位逻辑运算符里的按位异或，是对二进制的0/1比较，只有在两个比较的位不同时结果是1，否则为0.
            result ^= i;
        }
        return result;
    }

    @Test
    public void test(){
        int[] a = {4,2,5,1,4,2,1};
        System.out.println(singleNumber(a));
    }
}

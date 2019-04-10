package top.wujinxing.LeetCode.Array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: wujinxing
 * @date: 2019/4/10 09:58
 * @description: 判断数组中是否含有重复元素
 */
public class Contains_Duplicate_217 {
    public boolean ContainsDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        return set.size() < nums.length;
    }

    @Test
    public void test(){
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {1,2,3,3,5,6,7};
        System.out.println(ContainsDuplicate(a));
        System.out.println(ContainsDuplicate(b));
    }
}

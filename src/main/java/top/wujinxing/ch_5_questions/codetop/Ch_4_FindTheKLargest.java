package top.wujinxing.ch_5_questions.codetop;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author 01397208
 * @date 2022-02-23
 */
public class Ch_4_FindTheKLargest {

    public int findTheKLargest(int[] nums, int k) {
        return 0;
    }

    @Test
    public  void test() {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;

        int i1 = new Ch_4_FindTheKLargest().findTheKLargest(nums1, k1);
        int i2 = new Ch_4_FindTheKLargest().findTheKLargest(nums2, k2);
        Assert.assertEquals(5, i1);
        Assert.assertEquals(4, i2);
    }
}

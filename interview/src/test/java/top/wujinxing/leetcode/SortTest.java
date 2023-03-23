package top.wujinxing.leetcode;

import org.junit.Assert;
import org.junit.Test;
import top.wujinxing.leetcode.sort.Ch_179_LargestNumber;
import top.wujinxing.leetcode.sort.Ch_347_TopKFrequentElements;
import top.wujinxing.leetcode.sort.Ch_912_SortAnArray;

/**
 * @author wujinxing
 * @date 2023/3/22
 */
public class SortTest {

    @Test
    public void sortArray() {
        int[] array = new int[]{5, 2, 3, 1};
        int[] array2 = new int[]{5, 1, 1, 2, 0, 0};
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5}, Ch_912_SortAnArray.sortArray(array));
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 5}, Ch_912_SortAnArray.sortArray(array2));
    }

    @Test
    public void topK() {
        int[] numbs = new int[]{1, 1, 1, 2, 2, 3};
        Assert.assertArrayEquals(new int[]{1, 2}, Ch_347_TopKFrequentElements.topKFrequent(numbs, 2));
    }

    @Test
    public void largestNumber() {
        Assert.assertEquals("210", Ch_179_LargestNumber.largestNumber(new int[]{10, 2}));
        Assert.assertEquals("9534330", Ch_179_LargestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}

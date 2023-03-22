package top.wujinxing.leetcode;

import org.junit.Assert;
import org.junit.Test;
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
}

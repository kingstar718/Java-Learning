package top.wujinxing.leetcode;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.Lists;
import org.junit.Test;
import top.wujinxing.leetcode.array.Ch41FirstMissingPositive;
import top.wujinxing.leetcode.array.Ch54SpiralMatrix;

import java.util.Arrays;

public class ArrayTest {


    @Test
    public void testFirstMissingPositive() {
        int[] numbs = {1, 2, 0};
        int[] numbs2 = {3, 4, -1, 1};
        int[] numbs3 = {7, 8, 9, 11, 12};
        assertEquals(3, new Ch41FirstMissingPositive().firstMissingPositive(numbs));
        assertEquals(2, new Ch41FirstMissingPositive().firstMissingPositive(numbs2));
        assertEquals(1, new Ch41FirstMissingPositive().firstMissingPositive(numbs3));
        assertEquals(1, new Ch41FirstMissingPositive().firstMissingPositive(new int[]{-1, -2}));
        assertEquals(1, new Ch41FirstMissingPositive().firstMissingPositive(new int[]{}));
        assertEquals(1, new Ch41FirstMissingPositive().firstMissingPositive(new int[]{-1}));
    }

    @Test
    public void testSpiralOrder() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(Lists.newArrayList(1, 2, 3, 6, 9, 8, 7, 4, 5), new Ch54SpiralMatrix().spiralOrder(matrix));
        assertEquals(Lists.newArrayList(), new Ch54SpiralMatrix().spiralOrder(null));
    }

}

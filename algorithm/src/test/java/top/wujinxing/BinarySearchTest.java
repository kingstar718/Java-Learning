package top.wujinxing;

import org.junit.Test;
import top.wujinxing.binarysearch.BinarySearch;
import top.wujinxing.binarysearch.BinarySearchExt;

import static org.junit.Assert.assertEquals;

/**
 * @author 01397208
 * @date 2023/11/14
 */
public class BinarySearchTest {

    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] arr2 = {2, 3, 4, 5, 5, 5, 6, 7, 7, 7, 7, 8};

    @Test
    public void bs1Test() {
        assertEquals(3, BinarySearch.bs1(arr, 4));
        assertEquals(5, BinarySearch.bs1(arr, 6));
    }

    @Test
    public void bs2Test() {
        assertEquals(3, BinarySearch.bs2(arr, 4));
        assertEquals(5, BinarySearch.bs2(arr, 6));
    }

    @Test
    public void bs3Test() {
        assertEquals(3, BinarySearch.bs3(arr, 4));
        assertEquals(5, BinarySearch.bs3(arr, 6));
        assertEquals(3, BinarySearch.bs3(arr2, 5));
        assertEquals(7, BinarySearch.bs3(arr2, 7));
    }

    @Test
    public void firstEqualTest() {
        // 第一个与目标相等的数组元素的索引
        assertEquals(3, BinarySearchExt.firstEqual(arr, 4));
        assertEquals(5, BinarySearchExt.firstEqual(arr, 6));
        assertEquals(3, BinarySearchExt.firstEqual(arr2, 5));
        assertEquals(7, BinarySearchExt.firstEqual(arr2, 7));
    }

    @Test
    public void firstLargeEqualTest() {
        // 第一个大于等于目标的数组元素索引
        assertEquals(3, BinarySearchExt.firstLargeEqual(arr, 4));
        assertEquals(5, BinarySearchExt.firstLargeEqual(arr, 6));
        assertEquals(3, BinarySearchExt.firstLargeEqual(arr2, 5));
        assertEquals(7, BinarySearchExt.firstLargeEqual(arr2, 7));
    }


    @Test
    public void lastEqualTest() {
        // 最后一个与目标元素相等的数组元素索引
        assertEquals(3, BinarySearchExt.lastEqual(arr, 4));
        assertEquals(5, BinarySearchExt.lastEqual(arr, 6));
        assertEquals(5, BinarySearchExt.lastEqual(arr2, 5));
        assertEquals(10, BinarySearchExt.lastEqual(arr2, 7));
    }


    @Test
    public void lastSmallEqualTest() {
        // 最后一个与目标元素相等的数组元素索引
        assertEquals(3, BinarySearchExt.lastSmallEqual(arr, 4));
        assertEquals(5, BinarySearchExt.lastSmallEqual(arr, 6));
        assertEquals(5, BinarySearchExt.lastSmallEqual(arr2, 5));
        assertEquals(10, BinarySearchExt.lastSmallEqual(arr2, 7));
    }

}

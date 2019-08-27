package top.wujinxing.ch_3_algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wujinxing
 * @ date: 2019/1/15 16:51
 * @ description: 插入排序
 * 1.从第一个元素开始，可认为该元素已被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4.重复步骤3，直到找到已排序的元素小于或等于新元素的位置
 * 5.将新元素插入到该位置后，
 * 6.重复步骤2-5
 */
public class Insertion_Sort {

    public static void insertionSort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];      //取出下一个元素，在已经排序的元素序列中从后向前扫描
            for (int j = i; j >= 0; j--) {
                if (j > 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];    //如果该元素大于已排序的元素，则将该元素移到下一位置
                    System.out.println("Sorting: " + Arrays.toString(arr));
                } else {
                    arr[j] = temp;
                    System.out.println("Sorting: " + Arrays.toString(arr));
                    break;
                }
            }
        }
    }

    public static void insertionSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] <= arr[j])
                    break;
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                System.out.println("Sorting: " + Arrays.toString(arr));
            }
        }
    }

    @Test
    public void Test() {
        int[] arr = {11, 1, 4, 5, 7, 9, 6, 2, 3, 45, 68, 44, 55, 777, 45};
        //insertionSort1(arr);
        insertionSort2(arr);
    }
}

package top.wujinxing.ch_3_algorithm.sort;

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
public class InsertSort {

    public static void insertionSort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //取出下一个元素，在已经排序的元素序列中从后向前扫描
            int temp = arr[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && arr[j - 1] > temp) {
                    //如果该元素大于已排序的元素，则将该元素移到下一位置
                    arr[j] = arr[j - 1];
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
                if (arr[j - 1] <= arr[j]) {
                    break;
                }
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                System.out.println("Sorting: " + Arrays.toString(arr));
            }
        }
    }

    public static void insertionSort3(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j + 1] = value;
        }
        System.out.println(Arrays.toString(a));
    }


    public static void main(String[] args) {
        int[] arr = {11, 1, 4, 5, 7, 9, 6, 2, 3, 45, 68, 44, 55, 777, 45};
        insertionSort1(Arrays.copyOf(arr, arr.length));
        insertionSort2(Arrays.copyOf(arr, arr.length));
        insertionSort3(arr, arr.length);
    }
}

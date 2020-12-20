package top.wujinxing.ch_3_algorithm.sort;


import java.util.Arrays;

/**
 * @author: wujinxing
 * @date: 2019/1/9 16:55
 * description:选择排序
 * 1. 找出数组中最小的数，将该值与当前的i值交换--即第一个最小值与索引为0的值进行交换，第二个最小值与索引值1的进行交换
 * 2. i依次等于0-n，即逐个将最小值放在当前的i上，即完成排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 9, 11, 8, 10, 12, 0, 2};
        selectSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            if (arr == null || length <= 1) {
                return;
            }
            int minIndex = i;
            //找出最小元素的数组下标，与当前的i交换
            for (int j = i + 1; j < length; ++j) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                //数组内数据的交换形式
                swapArr(arr, minIndex, i);
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void swapArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 从原始数组中寻找到最小的值，将该值与当前的i进行交换，
     * 即第一个最小值与索引为0的值进行交换，第二个最小值与索引值1的进行交换
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n) {
        for (int index = 0; index < n - 1; index++) {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
            swap(a, index, indexOfNextSmallest);
        }
    }

    /**
     * 寻找数组中最小的值
     */
    private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
        T min = a[first];
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++) {
            if (a[index].compareTo(min) < 0) {
                min = a[index];
                indexOfMin = index;
            }
        }
        return indexOfMin;
    }

    /**
     * 交换数组的值
     */
    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

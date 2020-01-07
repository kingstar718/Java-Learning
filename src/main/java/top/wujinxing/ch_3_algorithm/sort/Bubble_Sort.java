package top.wujinxing.ch_3_algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wujinxing
 * @ date: 2019/1/16 15:12
 * @ description:冒泡排序
 * 1.比较相邻两个元素的大小，如果第一个比第二个大，就交换两个元素位置
 * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 3.针对所有的元素重复以上的步骤，除了最后一个。即第二轮遍历长度为n-1，第三轮n-2。。。
 * 4.持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
 * 时间复杂度为n+n-1+n-2+...+2+1--->n(n+1)/2--->O(n^2)
 */
public class Bubble_Sort {
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {    //外层循环移动游标
            for (int j = 0; j < i && (j + 1) < i; j++) {   //内层循环遍历游标及之后（或之前）的元素
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println("Sorting: " + Arrays.toString(arr));
                }
            }
            //System.out.println("Sorting: " + Arrays.toString(arr));
        }
    }

    public void bubbleSort2(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            boolean flag = false;  // 提前退出冒泡循环的标志位
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) { // 交换
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true; // 提前退出
                }
            }
            if (!flag) break;  // 表示没有数据交换，提前退出
        }
    }

    @Test
    public void test() {
        int[] a = {2, 3, 5, 4, 1, 55, 23, 45, 21, 2, 3, 9};
        bubbleSort(a);
        int[] a2 = {2, 3, 5, 4, 1, 55, 23, 45, 21, 2, 3, 9};
        bubbleSort2(a2, a2.length);
        System.out.println(Arrays.toString(a2));
    }
}

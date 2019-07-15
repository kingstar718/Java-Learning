package top.wujinxing.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wujinxing
 * @date: 2019/1/16 15:12
 * @description:冒泡排序
 * 1.比较相邻两个元素的大小，如果第一个比第二个大，就交换两个元素位置
 * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 3.针对所有的元素重复以上的步骤，除了最后一个。
 * 4.持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
 *
 */
public class Bubble_Sort {
    public static void bubbleSort(int[] arr){
        for(int i = arr.length; i > 0; i--){    //外层循环移动游标
            for (int j = 0; j < i && (j+1) < i; j++){   //内层循环遍历游标及之后（或之前）的元素
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    System.out.println("Sorting: " + Arrays.toString(arr));
                }

            }
        }
    }

    @Test
    public void test(){
        int[] a = {2,3,5,4,1,55,23,45,21,2,3,9};
        bubbleSort(a);
    }
}

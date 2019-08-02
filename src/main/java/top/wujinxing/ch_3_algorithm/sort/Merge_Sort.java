package top.wujinxing.ch_3_algorithm.sort;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/1/10 14:45
 * @description:归并排序
 */
public class Merge_Sort {
    //打印数组
    public static void printArr(int[] arr){
        for (int a : arr){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;  //左序列指针
        int j = mid + 1;  //右序列指针
        int t = 0;  //临时数组指针
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        //将左边剩余排序元素填充进数组
        while (i<=mid){
            temp[t++] = arr[i++];
        }
        //将右边剩余元素填充进数组
        while (j<=right){
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp数组元素拷贝回原数组中
        while (left <= right){
            arr[left++] = temp[t++];
        }
        //打印每轮数组排序结果
        printArr(arr);
    }

    public static void mergeSort(int[] arr, int left, int right,int[] temp){
        if (left<right){
            int mid = (left+right)/2;
            mergeSort(arr, left, mid, temp);    //左边归并排序，使得左子序列有序
            mergeSort(arr,mid+1, right, temp);  //右边归并排序，使得右子序列有序
            merge(arr, left, mid, right, temp);     //将两个有序子数组合并操作
        }
    }

    @Test
    public void test(){
        int[] arr = {1,3,4,2,56,23,24,22,1,3,15,45,56};
        int[] temp = new int[arr.length];
        int right = arr.length-1;
        mergeSort(arr,0,right,temp);
    }
}

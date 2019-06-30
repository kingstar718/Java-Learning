package top.wujinxing.Sort;

import org.junit.Test;

/**
 * @author wujinxing
 * @ date 2019/1/10 15:45
 * @ description: 快速排序
 * 1.先从数列中取出一个数作为基准书
 * 2.分区过程中，比该数大的全放到右边，小于等于该数的全放在左边
 * 3.在对左右区间重复第二步，直到个区间只有一个数
 */
public class Quick_Sort {
    //打印数组
    private static void printArr(int[] arr){
        for (int a : arr){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void quickSort(int[] arr, int low, int high){
        if (arr.length <= 0){
            return;
        }
        if (low >= high){
            return;
        }
        int left = low;
        int right = high;

        int temp = arr[left]; //，坑1：保存基准的值
        while (left < right){
            //坑2：从后往前找比基准值小的元素，插入到基准值的坑中
            while (left < right && arr[right] >= temp){
                right--;
            }
            arr[left] = arr[right];
            //坑3：从前往后找比基准值大的元素，插入到坑2中
            while (left < right && arr[left] <= temp){
                left++;
            }
            arr[right] = arr[left];
        }
        //基准值插入到坑3中
        arr[left] = temp;
        printArr(arr);
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }
    @Test
    public void test(){
        int[] arr = {3,4,1,2,5,7,8,12,32,12,12,33,221,0,1};
        quickSort(arr,0, arr.length - 1);
    }
}

package top.wujinxing.offer;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/3/12 11:44
 * @description:统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int GetNumberOfKTest(int[] array, int k){
        int length = array.length;
        if (length == 0) return 0;

        int firstK = getFirstK(array, k, 0, length-1);
        int lastK = getSecordK(array, k, 0, length-1);
        if (firstK != -1 && lastK != -1){
            return lastK - firstK + 1;
        }
        return 0;
    }

    //递归二分查找
    private int getFirstK(int[] array, int k, int start, int end){
        if (start > end) return -1;

        int mid = (start + end) >> 1;
        if (array[mid] > k){
            return getFirstK(array, k, start, mid - 1);
        }else if(array[mid] < k){
            return getFirstK(array, k, mid + 1, end);
        }else if (mid-1 >= 0 && array[mid-1] == k){
            return getFirstK(array, k, start, mid-1);
        }else {
            return mid;
        }
    }

    //循环二分查找
    private int getSecordK(int[] array, int k, int start, int end){
        int length = array.length;
        int mid = (start + end) >> 1;
        while (start <= end){
            if (array[mid] > k){
                end = mid - 1;
            }else if (array[mid] < k){
                start = mid + 1;
            }else if (mid+1 < length && array[mid+1] == k){
                start = mid + 1;
            }else {
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }

    @Test
    public void test(){
        int[] a = {1,2,4,5,7,8,8,9,9,10,11,13};
        int[] b = {1,2,4,5,7,8,8,9,9,10,11,11,11,11,13};
        System.out.println(GetNumberOfKTest(a,9));
        System.out.println(GetNumberOfKTest(b,11));
        System.out.println(getFirstK(a,8,0,11));
    }
}

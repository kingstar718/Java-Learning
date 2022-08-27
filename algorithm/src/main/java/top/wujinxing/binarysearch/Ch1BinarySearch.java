package top.wujinxing.binarysearch;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/8/23 13:52
 * description 二分查找
 *
 * 默认查找的顺序表均为递增
 */
public class Ch1BinarySearch {

    @Test
    public void test(){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        //两种形式
        System.out.println(bs1(arr, 6));
        System.out.println(bs2(arr, 6));

        int[] arr2 = {1,2,3,4,5,6,6,6,6,7,8,9};
        //查找第一个与key相等的元素
        System.out.println(firstEqual(arr, 6));//5
        System.out.println(bs1(arr2, 6));//5
        //查找最后一个与key相等的元素
        System.out.println(lastEqual(arr2, 6));//8
        //查找最后一个小于等于key的元素
        System.out.println(lastSmallEqual(arr2, 6)); //8
    }

    private static int bs1(int[] arr, int key){
        int L = 0, R = arr.length - 1;
        int mid;
        while (L <= R){
            mid = (L + R) / 2;
            if (arr[mid] == key){
                return mid;
            }
            if (arr[mid] > key){  //key在[L, mid-1]内
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return -1;
    }

    //和上面的完全一样，只是一开始R不是arr.length-1 而是arr.length
    private static int bs2(int[] arr, int key){
        int L = 0, R = arr.length, mid;//注意这里R = arr.length 所以在[L,R)开区间中找

        while (L < R){
            mid = (L + R) >> 1;//注意这里 不是 L <= R
            if (arr[mid] == key)
                return mid;
            if (arr[mid] > key)
                R = mid;// 在[L,mid)中找
            else
                L = mid + 1;
        }
        return -1;
    }

    /**查找第一个与key相等的元素的下标，　如果不存在返回-1　*/
    private static int firstEqual(int[] arr, int key){
        int L = 0, R = arr.length - 1, mid; //在[L,R]查找第一个>=key的

        while (L <= R){
            mid = (L + R) >> 1;
            if (arr[mid] >= key)
                R = mid - 1;
            else
                L = mid + 1;
        }
        if (L < arr.length && arr[L] == key)
            return L;

        return -1;
    }

    /**查找第一个大于等于key的元素的下标*/
    private static int firstLargeEqual(int[] arr, int key){
        int L = 0, R = arr.length - 1, mid;

        while (L <= R){
            mid = (L + R) >> 1;
            if (arr[mid] >= key) //查找大于的改成 > 即可
                R = mid - 1;
            else
                L = mid + 1;
        }
        return L;
    }

    /**查找最后一个与key相等的元素的下标，　如果没有返回-1*/
    private static int lastEqual(int[] arr, int key){
        int L = 0, R = arr.length - 1, mid;

        while (L <= R){
            mid = (L + R) >> 1;
            if (arr[mid] <= key)
                L = mid + 1;
            else
                R = mid - 1;
        }
        //等于的条件
        if (R >= 0 && arr[R] == key)
            return R;

        return -1;
    }

    /**查找最后一个小于等于key的元素的下标 */
    private static int lastSmallEqual(int[] arr, int key){
        int L = 0, R = arr.length - 1, mid;

        while (L <= R){
            mid = (L + R) >> 1;
            if (arr[mid] <= key) //查找最后一个小于的改成 < 即可
                L = mid + 1;
            else
                R = mid - 1;
        }
        return R;
    }
}

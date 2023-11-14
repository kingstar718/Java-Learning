package top.wujinxing.binarysearch;


/**
 * @author wujinxing
 * @date 2019/8/23 13:52
 * description 二分查找
 * <p>
 * 默认查找的顺序表均为递增
 */
public class BinarySearch {

    /**
     * 不支持数组内有重复数据
     */
    public static int bs1(int[] arr, int key) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            //key在[L, mid-1]内
            if (arr[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 和上面的完全一样，只是一开始R不是arr.length-1 而是arr.length
     * 不支持数组内有重复数据
     */
    public static int bs2(int[] arr, int key) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        //注意这里R = arr.length 所以在[L,R)开区间中找
        int left = 0, right = arr.length, mid;

        while (left < right) {
            //注意这里 不是 L <= R
            mid = (left + right) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            // 在[L,mid)中找
            if (arr[mid] > key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 对于递增数组有重复数据的，取重复数据第一个的索引值
     */
    public static int bs3(int[] arr, int k) {
        //判断arr是否合规
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int l = 0, r = arr.length, mid;
        while (l < r) {
            mid = (l + r) / 2;
            //k的值小于等于中间值，代表查找值在当前L和mid之间，因此要将R设置为mid
            if (arr[mid] >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        //思考：为什么是这样的返回
        //
        if (l < arr.length && arr[l] == k) {
            return l;
        }
        return -1;
    }

}

package top.wujinxing.sword_offer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/9/11 9:52
 * description 数字在排序数组中出现的此时
 * 统计一个数字在排序数组中出现的次数。
 *
 * 时间复杂度低于O(N)
 * 二分查找变形
 */
public class ch_37_GetNumberOfK {

    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0 || array == null)
            return 0;
        int first = firstEqual(array, k);
        int second = secondEqual(array, k);
        if (first != -1 && second != -1)
            return second - first + 1;
        return 0;
    }

    private static int firstEqual(int[] array, int k) {
        int L = 0, R = array.length - 1;
        int mid;
        while (L <= R) {
            mid = (L + R) / 2;
            if (array[mid] >= k)
                R = mid - 1;
            else
                L = mid + 1;
        }
        if (L < array.length && array[L] == k) {
            return L;
        }
        return -1;
    }

    private static int secondEqual(int[] array, int k) {
        int L = 0, R = array.length - 1;
        int mid;
        while (L <= R) {
            mid = (L + R) / 2;
            if (array[mid] <= k)
                L = mid + 1;
            else
                R = mid - 1;
        }
        if (R >= 0 && array[R] == k) {
            return R;
        }
        return -1;
    }

    @Test
    public void tess(){
        int[] arr = {0,1,2,3,4,4,4,4,5,6,7};
        System.out.println(GetNumberOfK(arr, 4));
    }
}

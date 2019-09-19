package top.wujinxing.ch_3_algorithm.binarysearch;

/**
 * @author wujinxing
 * date 2019/9/19 22:52
 * description 查找升序数组中第一个与k相等的值的索引
 * <p>
 * 如 ：2 3 4 5 5 5 6 7 8 k = 5
 * 输出：3
 */
public class ch_2_bs2 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 5, 5, 6, 7, 7, 7, 7, 8};
        System.out.println(bs2(arr, 5));
        System.out.println(bs2(arr, 7));
    }

    private static int bs2(int[] arr, int k) {
        if (arr == null || arr.length <= 0)
            return -1;
        int L = 0, R = arr.length, mid;

        while (L < R) {
            mid = (L + R) >> 1;
            if (arr[mid] >= k) //k的值小于中间值
                R = mid - 1;
            else
                L = mid + 1;
        }
        if (L < arr.length && arr[L] == k)
            return L;

        return -1;
    }
}

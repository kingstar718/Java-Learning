package top.wujinxing.binarysearch;

/**
 * @author wujinxing
 * date 2019/9/19 22:52
 * description 查找升序数组中第一个与k相等的值的索引
 * <p>
 * 如 ：2 3 4 5 5 5 6 7 8 k = 5
 * 输出：3 (第一个匹配的值的索引)
 */
public class Ch2BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 5, 5, 6, 7, 7, 7, 7, 8};
        System.out.println(bs2(arr, 5));
        System.out.println(bs2(arr, 7));
    }

    private static int bs2(int[] arr, int k) {
        //判断arr是否合规
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int l = 0, r = arr.length, mid;
        while (l < r) {
            mid = (l + r) >> 1;
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

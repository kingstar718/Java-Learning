package top.wujinxing.binarysearch;

/**
 * @author wujinxing
 * date 2019/9/19 22:52
 * description 查找升序数组中第一个与k相等的值的索引
 * <p>
 * 如 ：2 3 4 5 5 5 6 7 8 k = 5
 * 输出：3 (第一个匹配的值的索引)
 */
public class BinarySearchExt {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] arr2 = {1, 2, 3, 4, 5, 6, 6, 6, 6, 7, 8, 9};
        //查找第一个与key相等的元素
        System.out.println(firstEqual(arr, 6));//5
        //查找最后一个与key相等的元素
        System.out.println(lastEqual(arr2, 6));//8
        //查找最后一个小于等于key的元素
        System.out.println(lastSmallEqual(arr2, 6)); //8
    }


    /**
     * 查找第一个与key相等的元素的下标，如果不存在返回-1
     */
    public static int firstEqual(int[] arr, int key) {
        //在[L,R]查找第一个>=key的
        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (arr[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < arr.length && arr[left] == key) {
            return left;
        }
        return -1;
    }

    /**
     * 查找第一个大于等于key的元素的下标
     */
    public static int firstLargeEqual(int[] arr, int key) {
        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            //查找大于的改成 > 即可
            if (arr[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 查找最后一个与key相等的元素的下标，　如果没有返回-1
     */
    public static int lastEqual(int[] arr, int key) {
        int left = 0, right = arr.length - 1, mid;

        while (left <= right) {
            mid = (left + right) >> 1;
            if (arr[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //等于的条件
        if (right >= 0 && arr[right] == key) {
            return right;
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于key的元素的下标
     */
    public static int lastSmallEqual(int[] arr, int key) {
        int left = 0, right = arr.length - 1, mid;

        while (left <= right) {
            mid = (left + right) >> 1;
            //查找最后一个小于的改成 < 即可
            if (arr[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }


}

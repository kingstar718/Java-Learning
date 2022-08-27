package top.wujinxing.recursive;

/**
 * @author wujinxing
 * date 2019 2019/8/18 11:17
 * description 二分查找
 */
public class ch_5_binarySearch {

    /**
     * 二分查找递归实现
     * @param array 目标数组
     * @param low 左边界
     * @param high 右边界
     * @param target 目标值
     * @return 目标值所在位置
     */
    public static int binarySearch(int[] array, int low, int high, int target){
        //递归终止条件
        if (low < high){
            int mid = (low + high) >> 1;
            if (array[mid] == target){
                return mid + 1;     // 返回目标值的位置，从1开始
            }else if (array[mid] > target){
                binarySearch(array, low, mid - 1, target); //由于array[mid]不是目标值，因此再次递归搜索时，可以将其排除
            }else {
                binarySearch(array, mid + 1, high, target); //由于array[mid]不是目标值，因此再次递归搜索时，可以将其排除
            }
        }
        return -1;
    }

    public static int binarySearchNoRecursive(int[] array, int low, int high, int target){
        //循环
        while (low <= high){
            int mid = (low + high) >> 1;
            if (array[mid] == target){
                return mid + 1; // 返回目标值的位置，从1开始
            }else if (array[mid] > target){
                high = mid - 1; // 由于array[mid]不是目标值，因此再次递归搜索时，可以将其排除
            }else {
                low = mid + 1; // 由于array[mid]不是目标值，因此再次递归搜索时，可以将其排除
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(binarySearch(arr,0, 6, 4));
        System.out.println(binarySearchNoRecursive(arr, 0 , 6, 4));
    }
}

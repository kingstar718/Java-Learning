package top.wujinxing.sword_offer;

/**
 * @author wujinxing
 * date 2019 2019/9/4 13:22
 * description 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 在一个有序数组中查找一个元素可以用二分查找，二分查找也称为折半查找，每次都能将查找区间减半，这种折半特
 * 性的算法时间复杂度都为 O(logN)。
 * 本题可以修改二分查找算法进行求解：
 * 当 nums[m] <= nums[h] 的情况下，说明解在 [l, m] 之间，此时令 h = m；
 * 否则解在 [m + 1, h] 之间，令 l = m + 1。
 */
public class ch_06_minNumberInRotateArray {

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 2, 3};
        System.out.println(minNumberInRotateArray(arr));
    }

    private static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int left = 0, right = array.length - 1;
        while (left < right) {
            int m = left + (right - left) / 2;
            //解在left-m之间
            if (array[m] <= array[right]) {
                right = m;
            } else { // 解在m+1-right之间
                left = m + 1;
            }
        }
        return array[left];
    }
}

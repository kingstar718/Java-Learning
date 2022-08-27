package top.wujinxing.offer;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/4/18 10:22
 * @description:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 在一个有序数组中查找一个元素可以用二分查找，二分查找也称为折半查找，每次都能将查找区间减半，这种折半特
 * 性的算法时间复杂度都为 O(logN)。
 * 本题可以修改二分查找算法进行求解：
 * 当 nums[m] <= nums[h] 的情况下，说明解在 [l, m] 之间，此时令 h = m；
 * 否则解在 [m + 1, h] 之间，令 l = m + 1。
 */
public class minNumberInRotateArray {

    public int minNumberInRotateArrayTest(int [] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[h])
                return minNumber(nums, l, h);
            else if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }
    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++)
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        return nums[l];
    }

    public int minNumberInRotateArrayTest2(int[] array){
        if (array.length == 0){
            return 0;
        }
        int l= 0, h = array.length-1;
        while (l < h){
            int m = l + (h-l)/2;
            if (array[m] <= array[h]){
                h = m;
            }else {
                l = m + 1;
            }
        }
        return array[l];
    }

    @Test
    public void Test(){
        int[] a = {3,4,5,1,2};
        System.out.println(minNumberInRotateArrayTest(a));
        System.out.println(minNumberInRotateArrayTest2(a));
    }

}



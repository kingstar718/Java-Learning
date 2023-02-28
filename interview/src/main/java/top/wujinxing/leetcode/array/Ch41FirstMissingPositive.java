package top.wujinxing.leetcode.array;


/**
 * @author wujinxing
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class Ch41FirstMissingPositive {

    public int firstMissingPositive(int[] numbs) {
        final int length = numbs.length;
        if (length == 0) {
            return 1;
        }
        int[] helper = new int[length + 1];
        // 将数组正数元素存入辅助数组中
        for (int n : numbs) {
            if (n > 0 && n < helper.length) {
                helper[n] = n;
            }
        }
        // 遍历查找，找到不一样的元素
        for (int i = 0; i < helper.length; i++) {
            if (helper[i] != i) {
                return i;
            }
        }
        return helper.length;
    }


}

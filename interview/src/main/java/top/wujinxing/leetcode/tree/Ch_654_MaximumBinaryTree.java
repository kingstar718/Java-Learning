package top.wujinxing.leetcode.tree;

/**
 * @author wujinxing
 * @date 2023/3/22
 * <p>
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/">654. 最大二叉树</a>
 * <p>
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * <p>
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 */
public class Ch_654_MaximumBinaryTree {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    private static TreeNode construct(int[] nums, int start, int end) {
        if (end - start < 1) {
            return null;
        }
        // 只剩一个元素
        if (end - start == 1) {
            return new TreeNode(nums[start]);
        }
        // 最大值位置
        int maxIndex = start;
        int maxVal = nums[start];
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        // 根节点
        TreeNode root = new TreeNode(maxVal);
        // 递归左半边部分
        root.left = construct(nums, start, maxIndex);
        root.right = construct(nums, maxIndex + 1, end);
        return root;
    }
}

package top.wujinxing.leetcode.tree;

/**
 * @author wujinxing
 * date 2019 2019/11/13 15:31
 * description 二叉树中的最大路径和
 */
public class ch_124_BinaryTreeMaximumPathSum {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(left + right + root.val, res);
        return Math.max(0, Math.max(left, right) + root.val);
    }
}

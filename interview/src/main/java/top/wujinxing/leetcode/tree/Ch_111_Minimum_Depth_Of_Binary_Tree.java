package top.wujinxing.leetcode.tree;

/**
 * @author wujinxing
 * @date 2023/3/15
 *
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/">111. 二叉树的最小深度</a>
 */
public class Ch_111_Minimum_Depth_Of_Binary_Tree {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // 左子树为空的情况
        if (root.left == null && root.right != null) {
            return rightDepth + 1;
        }
        // 右子树为空的情况
        if (root.left != null && root.right == null) {
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}

package top.wujinxing.leetcode.tree;

/**
 * @author wujinxing
 * @date 2023/3/16
 * <p>
 * 平衡二叉树
 * <p>
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/">110. 平衡二叉树</a>
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
public class Ch_110_Balanced_Binary_Tree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // 当前节点
        boolean isRootBalanced = Math.abs(leftDepth - rightDepth) <= 1;
        // 递归左子树
        boolean isLeftBalanced = isBalanced(root.left);
        // 递归右子树
        boolean isRightBalanced = isBalanced(root.right);
        // 平衡
        return isRootBalanced && isLeftBalanced && isRightBalanced;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // -------------------------------------------------------

    /**
     * 从下往上，类似二叉树的后序遍历
     */
    public static boolean isBalanced2(TreeNode root) {
        return helper(root) != -1;
    }

    private static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        if (left == -1) {
            return -1;
        }
        int right = helper(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

}

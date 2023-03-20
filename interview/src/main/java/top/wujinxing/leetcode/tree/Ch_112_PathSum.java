package top.wujinxing.leetcode.tree;

/**
 * @author wujinxing
 * @date 2023/3/20
 * </p>
 * <a href="https://leetcode.cn/problems/path-sum/">112. 路径总和</a>
 * <p>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 */
public class Ch_112_PathSum {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return traversal(root, targetSum);
    }

    static boolean traversal(TreeNode root, int count) {
        if (root == null) {
            return false;
        }
        // 找到满足条件路径
        if (root.left == null && root.right == null && count == root.val) {
            return true;
        }
        return traversal(root.left, count - root.val) || traversal(root.right, count - root.val);
    }
}

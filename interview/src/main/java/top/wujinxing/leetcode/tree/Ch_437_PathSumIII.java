package top.wujinxing.leetcode.tree;

/**
 * @author wujinxing
 * @date 2023/3/21
 * <p>
 * <a href="https://leetcode.cn/problems/path-sum-iii/">路径总和 III</a>
 * <p>
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class Ch_437_PathSumIII {

    static int result = 0;

    public static int pathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        traversal(root, targetSum);
        traversal(root.left, targetSum);
        traversal(root.right, targetSum);
        return result;
    }

    private static void traversal(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            result++;
        }
        traversal(root.left, sum);
        traversal(root.right, sum);
    }

}

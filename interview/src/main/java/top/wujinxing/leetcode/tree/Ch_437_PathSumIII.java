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

    public static int pathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum3(root.left, targetSum);
        ret += pathSum3(root.right, targetSum);
        return ret;
    }

    public static int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

}

package top.wujinxing.leetcode.tree;

/**
 * @author wujinxing
 * @date 2023/3/16
 * <p>
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * <a href="https://leetcode.cn/problems/sum-of-left-leaves/">404. 左叶子之和</a>
 */
public class Ch_404_Sum_of_Left_Leaves {

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // 判断根节点的左孩子十分为左叶子
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

}

package top.wujinxing.leetcode.tree;

/**
 * @ author: wujinxing
 * @ date: 2019/4/11 09:15
 * @ description: 二叉树的高度
 */
public class ch_104_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归求出二叉树的高度
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

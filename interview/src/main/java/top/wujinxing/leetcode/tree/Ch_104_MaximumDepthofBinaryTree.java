package top.wujinxing.leetcode.tree;

/**
 * @author wujinxing
 * @date 2019/4/11 09:15
 * <p>
 * 二叉树的高度
 * </p>
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/submissions/">二叉树的高度</a>
 */
public class Ch_104_MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归求出二叉树的高度
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}

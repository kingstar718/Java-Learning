package top.wujinxing.LeetCode.Tree;

/**
 * @ author: wujinxing
 * @ date: 2019/4/11 09:15
 * @ description: 二叉树的高度
 */
public class Maximum_Depth_of_Binary_Tree_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归求出二叉树的高度
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

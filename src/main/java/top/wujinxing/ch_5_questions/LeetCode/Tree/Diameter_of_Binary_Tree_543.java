package top.wujinxing.ch_5_questions.LeetCode.Tree;

/**
 * @ author: wujinxing
 * @ date: 2019/4/11 09:59
 * @ description: 两节点的最长路径
 *
 * Input:
 *
 *          1
 *         / \
 *        2  3
 *       / \
 *      4   5
 *
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class Diameter_of_Binary_Tree_543 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        max = Math.max(max, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

package top.wujinxing.LeetCode.Tree;

/**
 * @author: wujinxing
 * @date: 2019/4/11 10:11
 * @description: 翻转树
 *
 * Input:
 *  *
 *  *
 *  * ⁠    4
 *  * ⁠  /   \
 *  * ⁠ 2     7
 *  * ⁠/ \   / \
 *  * 1   3 6   9
 *  *
 *  * Output:
 *  *
 *  *
 *  * ⁠    4
 *  * ⁠  /   \
 *  * ⁠ 7     2
 *  * ⁠/ \   / \
 *  * 9   6 3   1
 */
public class Invert_Binary_Tree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;// 后面的操作会改变 left 指针，因此先保存下来
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}

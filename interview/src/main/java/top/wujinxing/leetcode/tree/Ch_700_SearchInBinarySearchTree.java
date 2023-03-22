package top.wujinxing.leetcode.tree;

/**
 * @author wujinxing
 * @date 2023/3/22
 * <p>
 * <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/">700. 二叉搜索树中的搜索</a>
 * <p>
 * 给定二叉搜索树（BST）的根节点和一个值。
 * 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */
public class Ch_700_SearchInBinarySearchTree {

    public static TreeNode searchBst(TreeNode root, int val) {
        if (root == null ||  root.val == val) {
            return root;
        }
        // 递归左子树
        if (val < root.val) {
            return searchBst(root.left, val);
        }
        // 递归右子树
        if (val > root.val) {
            return searchBst(root.right, val);
        }
        return null;

    }
}

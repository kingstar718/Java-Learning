package top.wujinxing.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujinxing
 * date: 2019/4/11 10:11
 * description: 翻转二叉树
 *     输入：					输出：
 *      4						4
 *    /   \				      /   \
 *   2     7				 7     2
 *  / \   / \			   /  \   /  \
 * 1   3 6   9           9    6 3    1
 */
public class ch_226_InvertBinaryTree {

    // 利用前序遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left;// 后面的操作会改变 left 指针，因此先保存下来
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    // 中序遍历
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        invertTree(root.left); // 递归找到左节点
        TreeNode rightTree = root.right;
        root.right = root.left;
        root.left = rightTree;
        // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
        invertTree(root.left);
        return root;
    }

    // 后序遍历，从下往上交换
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;

        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        root.right = leftTree;
        root.left = rightTree;
        return root;
    }

    // 层次遍历，直接左右交换即可
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode rightTree = node.right;
            node.right = node.left;
            node.left = rightTree;

            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return root;
    }
}

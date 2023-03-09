package top.wujinxing.leetcode.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wujinxing
 * @date 2019 2019/11/12 10:05
 * description 二叉树的层次遍历
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 链接：<a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal">二叉树的层次遍历</a>
 */
public class Ch_102_BinaryTreeLevelOrderTraversal {

    /**
     * 非递归
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        int level = 0;
        while (!queue.isEmpty()) {
            list.add(new ArrayList<>());
            // 记录子节点有多少个
            int levelLength = queue.size();
            // 既删除了节点，又添加了子节点
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.remove();
                list.get(level).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return list;
    }

    /**
     * 递归
     */
    static List<List<Integer>> levels = new ArrayList<>();

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }

    private static void helper(TreeNode node, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

}

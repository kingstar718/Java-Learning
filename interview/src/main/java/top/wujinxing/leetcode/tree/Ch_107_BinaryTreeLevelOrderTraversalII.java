package top.wujinxing.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wujinxing
 * @date 2023/3/13
 * </p>
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/">107. 二叉树的层序遍历 II</a>
 */
public class Ch_107_BinaryTreeLevelOrderTraversalII {

    /**
     * 给定一个二叉树，返回其节点值自底向上的层序遍历。
     * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            // 使用头查法插入每一层节点值集合
            res.addFirst(level);
        }
        return res;
    }
}

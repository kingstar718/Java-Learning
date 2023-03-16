package top.wujinxing.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujinxing
 * @date 2023/3/16
 * </p>
 * <p>
 * 完全二叉树的节点个数
 * <p>
 * 给你一课完全二叉树的根节点root，求出该树的节点个数
 * <p>
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数</a>
 */
public class Ch_222_CountCompleteTreeNodes {

    /**
     * 非递归
     */
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            sum++;
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return sum;
    }

    /**
     * 递归
     */
    public static int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes2(root.left);
        int rightCount = countNodes2(root.right);
        return leftCount + rightCount + 1;
    }

}

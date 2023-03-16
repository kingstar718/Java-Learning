package top.wujinxing.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujinxing
 * @date 2023/3/16
 * <p>
 * <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/">513. 找树左下角的值</a>
 * <p>
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 */
public class Ch_513_Find_Bottom_Left_Tree_Value {

    public static int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int bottomLeftValue= 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    bottomLeftValue = curr.val;
                }
                //当前节点左孩子入队
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                //当前节点右孩子入队
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return bottomLeftValue;
    }

}

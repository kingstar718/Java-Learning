package top.wujinxing.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wujinxing
 * @date 2023/3/13
 */
public class Ch_32_SwordOffer_LevelOrder {

    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> nodes = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        // 根节点
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodes.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        // 结果数组
        int[] res = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            res[i] = nodes.get(i);
        }
        return res;
    }
}

package top.wujinxing.leetcode.tree;

import java.util.*;

/**
 * @author wujinxing
 * @date 2023/3/13
 */
public class Ch_32_SwordOffer_LevelOrder_III {

    /**
     * 请实现一个函数按照之字形顺序打印二叉树，
     * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
     * 第三行再按照从左到右的顺序打印，其他行以此类推。
     */
    public static List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 队列
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelCount = 1;
        while (!queue.isEmpty()) {
            // 当前队列size
            int queueSize = queue.size();
            // 使用双向链表存储每层节点
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 1; i <= queueSize; i++) {
                // 取节点
                TreeNode node = queue.poll();
                // 判断层级 奇数在后追加
                if (levelCount % 2 == 1) {
                    level.addLast(node.val);
                }
                // 偶数则在前追加
                if (levelCount % 2 == 0) {
                    level.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 添加每层节点
            res.add(level);
            levelCount++;
        }
        return res;
    }


    public static List<List<Integer>> levelOrder3_2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curr.val);
                } else {
                    levelList.offerFirst(curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            res.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }
}

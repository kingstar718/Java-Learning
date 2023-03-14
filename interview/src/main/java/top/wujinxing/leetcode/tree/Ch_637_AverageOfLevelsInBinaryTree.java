package top.wujinxing.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wujinxing
 * @date 2023/3/14
 * <p>
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 */
public class Ch_637_AverageOfLevelsInBinaryTree {

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0d;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }
}

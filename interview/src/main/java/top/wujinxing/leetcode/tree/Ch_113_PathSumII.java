package top.wujinxing.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wujinxing
 * @date 2023/3/20
 */
public class Ch_113_PathSumII {

    //结果
    static List<List<Integer>> result = new ArrayList<>(16);
    //路径
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traversal(root, targetSum);
        return result;
    }

    static void traversal(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        // 路径和
        sum -= root.val;
        // 添加节点
        path.offerLast(root.val);
        // 达到叶子节点，且路径满足要求
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new LinkedList<>(path));
        }
        traversal(root.left, sum);
        traversal(root.right, sum);
        //回溯
        path.pollLast();
    }
}

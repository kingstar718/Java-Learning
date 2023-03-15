package top.wujinxing.leetcode.tree;

import java.util.List;

/**
 * @author wujinxing
 * @date 2023/3/15
 * </p>
 * <a href="https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/">N 叉树的最大深度</a>
 */
public class Ch_559_Maximum_Depth_Of_N_Ary_Tree {

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int childMaxDepth = maxDepth(root.children.get(i));
            maxDepth = Math.max(maxDepth, childMaxDepth);
        }
        return maxDepth + 1;
    }

    static class Node {

        int val;

        List<Node> children;

    }
}

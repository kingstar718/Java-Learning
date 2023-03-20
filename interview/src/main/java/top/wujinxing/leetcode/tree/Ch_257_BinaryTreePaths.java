package top.wujinxing.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujinxing
 * @date 2023/3/20
 * <p>
 * <a href="https://leetcode.cn/problems/binary-tree-paths/">257. 二叉树的所有路径</a>
 */
public class Ch_257_BinaryTreePaths {

    /**
     * 深度优先搜索
     */
    public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        constructPaths(root, "", res);
        return res;
    }

    static void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder pathSb = new StringBuilder(path);
            pathSb.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                paths.add(pathSb.toString());
            } else {
                pathSb.append("->");
                constructPaths(root.left, pathSb.toString(), paths);
                constructPaths(root.right, pathSb.toString(), paths);
            }
        }
    }


    /**
     * 广度优先搜索
     */
    public static List<String> binaryTreePaths3(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(path + "->" + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(path + "->" + node.right.val);
                }
            }
        }
        return paths;
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        traversal(root, path, res);
        return res;
    }

    static void traversal(TreeNode current, LinkedList<Integer> path, List<String> result) {
        path.add(current.val);
        if (current.left == null && current.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
            return;
        }
        // 递归左子树
        if (current.left != null) {
            traversal(current.left, path, result);
            // 回溯
            path.removeLast();
        }
        if (current.right != null) {
            traversal(current.right, path, result);
            // 回溯
            path.removeLast();
        }
    }

}

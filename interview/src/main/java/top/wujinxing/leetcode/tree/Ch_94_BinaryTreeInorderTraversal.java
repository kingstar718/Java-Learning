package top.wujinxing.leetcode.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wujinxing
 * @date 2019 2019/11/11 19:40
 * <p>
 * 二叉树的中序遍历
 * <p>
 * 给定一个二叉树，返回它的中序遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * 链接：<a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal">中序遍历</a>
 */
public class Ch_94_BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            // 遍历子左输
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            // 取出栈中的节点
            TreeNode tmp = stack.pop();
            // 添加取出的节点
            res.add(tmp.val);
            // 指向右子树
            p = tmp.right;
        }
        return res;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private static void traversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        traversal(root.left, res);
        res.add(root.val);
        traversal(root.right, res);
    }

}

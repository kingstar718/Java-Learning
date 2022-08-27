package top.wujinxing.leetcode.tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/11/11 19:40
 * description 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序遍历。
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,3,2]
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */
public class ch_94_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            p = tmp.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> res) {
        if (root == null) return;
        traversal(root.left, res);
        res.add(root.val);
        traversal(root.right, res);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal2(root).toString());
        System.out.println(inorderTraversal(root).toString());
    }
}

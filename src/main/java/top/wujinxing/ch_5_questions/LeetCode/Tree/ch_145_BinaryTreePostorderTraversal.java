package top.wujinxing.ch_5_questions.LeetCode.Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/11/12 9:28
 * description 二叉树的后序遍历
 */
public class ch_145_BinaryTreePostorderTraversal {

    // 迭代形式
    public List<Integer> postOrderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            res.addFirst(node.val); // 注意这里，在头部添加节点
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }

    // 递归形式
    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> res) {
        if (root == null) return;

        traversal(root.left, res);
        traversal(root.right, res);
        res.add(root.val);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(postOrderTraversal(root).toString());
        System.out.println(postOrderTraversal2(root).toString());
    }
}

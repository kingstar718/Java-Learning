package top.wujinxing.ch_5_questions.LeetCode.Tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/11/11 20:12
 * description 二叉树前序遍历
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *  示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 */
public class ch_144_BinaryTreePreorderTraversal {

    /**
     * 使用栈来完成,我们先将根节点放入栈中,然后将其弹出,依次将该弹出的节点的右节点,
     * 和左节点,注意顺序,是右,左,为什么?因为栈是先入后出的,我们要先输出右节点,所以让它先进栈.
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode p = stack.pop();
            res.add(p.val);
            // 栈后进先出，所以前序遍历先右进后左进
            if(p.right != null){
                stack.push(p.right);
            }
            if(p.left != null){
                stack.push(p.left);
            }
        }
        return res;
    }

    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> res){
        if (root == null) return;
        res.add(root.val);
        traversal(root.left, res);
        traversal(root.right, res);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(preorderTraversal2(root).toString());
        System.out.println(preorderTraversal(root).toString());
    }
}

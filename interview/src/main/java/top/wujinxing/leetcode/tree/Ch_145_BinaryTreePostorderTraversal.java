package top.wujinxing.leetcode.tree;


import java.util.*;

/**
 * @author wujinxing
 * @date 2019 2019/11/12 9:28
 * <p>
 * 二叉树的后序遍历
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * <p>
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 链接：<a href="https://leetcode-cn.com/problems/binary-tree-postorder-traversal">二叉树的后序遍历</a>
 */
public class Ch_145_BinaryTreePostorderTraversal {

    public static List<Integer> postOrderTraversal4(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> s = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        while (root != null || !s.isEmpty()) {
            if (root == null && seen.contains(s.peek())) {
                ans.add(s.pop().val);
            } else if (root == null) {
                seen.add(s.peek());
                root = s.peek().right;
            } else {
                s.push(root);
                root = root.left;
            }
        }
        return ans;
    }

    public static List<Integer> postOrderTraversal3(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 根节点入栈
                stack.push(root);
                // 左子树
                root = root.left;
            }
            // 节点出栈
            root = stack.pop();
            // 判断节点右子树是否为空或已经访问过
            if (root.right == null || root.right == pre) {
                // 添加节点
                res.add(root.val);
                // 更新访问过的节点
                pre = root;
                // 使得下一次循环直接出栈
                root = null;
            } else {
                // 再次入栈
                stack.push(root);
                // 访问右子树
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 迭代形式
     */
    public static List<Integer> postOrderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            // 注意这里，在头部添加节点
            res.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }

    /**
     * 递归形式
     */
    public static List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        traversal(root, res);
        return res;
    }

    private static void traversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        traversal(root.left, res);
        traversal(root.right, res);
        res.add(root.val);
    }

}

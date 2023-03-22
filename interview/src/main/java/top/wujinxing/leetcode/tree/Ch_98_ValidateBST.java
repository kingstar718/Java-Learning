package top.wujinxing.leetcode.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author wujinxing
 * @date 2019 2019/12/2 20:26
 * update 2023年3月22日
 * <p>
 * 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。根节点的值为 5 ，但是其右子节点值为 4 。
 * 链接：<a href="https://leetcode-cn.com/problems/validate-binary-search-tree">98. 验证二叉搜索树</a>
 */
public class Ch_98_ValidateBST {

    //给定一个二叉树，判断其是否是一个有效的二叉搜索树。
    //
    //假设一个二叉搜索树具有如下特征：
    //
    //节点的左子树只包含小于当前节点的数。
    //节点的右子树只包含大于当前节点的数。
    //所有左子树和右子树自身必须也是二叉搜索树。

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    /** 迭代 */
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> uppers = new LinkedList<>(), lowers = new LinkedList<>();

    public void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isValidBST2(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null) {
                continue;
            }
            val = root.val;
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }

    /** 中序遍历 */
    public static boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inOrder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inOrder) {
                return false;
            }
            inOrder = root.val;
            root = root.right;
        }
        return true;
    }

    private static TreeNode pre;
    /** 中序遍历2 */
    public static boolean isValidBST4(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左子树
        boolean isValidLeft = isValidBST4(root.left);
        if (!isValidLeft) {
            return false;
        }
        // 根
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        // 右子树
        return isValidBST4(root.right);
    }

}

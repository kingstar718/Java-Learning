package top.wujinxing.leetcode.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/11/13 13:24
 * description 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 */
public class ch_617_MergeTwoBinaryTrees {

    /**
     * 对这两棵树同时进行前序遍历，并将对应的节点进行合并。
     * 在遍历时，如果两棵树的当前节点均不为空，我们就将它们的值进行相加，并对它们的左孩子和右孩子进行递归合并；
     * 如果其中有一棵树为空，那么我们返回另一颗树作为结果；
     * 如果两棵树均为空，此时返回任意一棵树均可（因为都是空）。
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * 1. 将两个树的根节点入栈
     * 2. 在迭代的每一步中，取出栈顶元素，将值相加
     * 3. 分别考虑两个点的左右孩子，都有左孩子，将其压入栈，只有一个节点有左孩子，将其作为第一个节点的左孩子；右孩子同理
     * 4. 返回第一个树的根节点。
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) continue;

            t[0].val +=t[1].val;

            if(t[0].left==null){
                t[0].left = t[1].left;
            }else {
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }
            if(t[0].right==null){
                t[0].right = t[1].right;
            }else {
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;
    }


    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        //Ch_102_BinaryTreeLevelOrderTraversal out = new Ch_102_BinaryTreeLevelOrderTraversal();
        //System.out.println(out.levelOrder(mergeTrees(t1, t2)).toString());
        //System.out.println(out.levelOrder(mergeTrees2(t1, t2)).toString());
    }
}

package top.wujinxing.leetcode.tree;

/**
 * @author wujinxing
 * @date 2023/3/21
 * <p>
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106. 从中序与后序遍历序列构造二叉树</a>
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 你可以假设树中没有重复的元素。
 */
public class Ch_106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (inOrder.length == 0 || postOrder.length == 0) {
            return null;
        }
        return buildTree(inOrder, 0, inOrder.length, postOrder, 0, postOrder.length);
    }

    public static TreeNode buildTree(int[] inOrder, int inStart, int inEnd,
                                     int[] postOrder, int postStart, int postEnd) {
        // 没有元素
        if (inEnd - inStart < 1) {
            return null;
        }
        // 只有一个元素
        if (inEnd - inStart == 1) {
            return new TreeNode(inOrder[inStart]);
        }
        // 后序数组最后一个元素就是根节点
        int rootVal = postOrder[postEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        // 根据根节点，找到该值在中序数组inOrder里的位置
        for (int i = inStart; i < inEnd; i++) {
            if (inOrder[i] == rootVal) {
                rootIndex = i;
            }
        }
        // 根据rootIndex切割左右子树
        root.left = buildTree(inOrder, inStart, rootIndex,
                postOrder, postStart, postStart + (rootIndex - inStart));
        root.right = buildTree(inOrder, rootIndex + 1, inEnd,
                postOrder, postStart + (rootIndex - inStart), postEnd - 1);
        return root;
    }

}

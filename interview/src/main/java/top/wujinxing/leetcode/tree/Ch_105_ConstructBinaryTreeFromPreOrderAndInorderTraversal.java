package top.wujinxing.leetcode.tree;

import java.util.ArrayList;

/**
 * @author wujinxing
 * @date 2019 2019/11/18 13:44
 * update 2023年3月22日
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal">根据一棵树的前序遍历与中序遍历构造二叉树</a>
 */
public class Ch_105_ConstructBinaryTreeFromPreOrderAndInorderTraversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }


    private static TreeNode buildTree(int[] preOrder, int preLeft, int preRight,
                               int[] inOrder, int inLeft, int inRight) {
        // 终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 根节点值
        int pivot = preOrder[preLeft];
        TreeNode root = new TreeNode(pivot);
        // 根节点下标
        int pivotIndex = inLeft;
        while (inOrder[pivotIndex] != pivot) {
            pivotIndex++;
        }

        // 左子树的前序的尾：前序头 + （中序根节点位置 - 中序头）
        // 右子树的前序的头：前序头 + （中序根节点位置 - 中序头） + 1
        root.left = buildTree(preOrder, preLeft + 1, preLeft + (pivotIndex - inLeft),
                inOrder, inLeft, pivotIndex - 1);
        root.right = buildTree(preOrder, preLeft + (pivotIndex - inLeft) + 1, preRight,
                inOrder, pivotIndex + 1, inRight);

        return root;
    }

}
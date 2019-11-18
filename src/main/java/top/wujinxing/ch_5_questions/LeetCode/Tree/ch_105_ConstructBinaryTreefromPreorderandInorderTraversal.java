package top.wujinxing.ch_5_questions.LeetCode.Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/11/18 13:44
 * description
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class ch_105_ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) preOrder.add(preorder[i]);
        for (int i = 0; i < preorder.length; i++) inOrder.add(inorder[i]);
        TreeNode root = helper(preOrder, inOrder);*/
        int preLength = preorder.length;
        int inLength = inorder.length;
        if (preLength != inLength) return null;

        return buildTree(preorder, 0, preLength - 1, inorder, 0, inLength - 1);
    }

    // 过过不了所有
    private TreeNode helper(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        int length = inOrder.size();

        if (length == 0) return null;

        ArrayList<Integer> preLeft = new ArrayList<>();
        ArrayList<Integer> preRight = new ArrayList<>();
        ArrayList<Integer> inLeft = new ArrayList<>();
        ArrayList<Integer> inRight = new ArrayList<>();

        TreeNode root = new TreeNode(preOrder.get(0)); //根节点

        // 找到中序遍历根节点的位置
        int gen = 0;
        for (int i = 0; i < length; i++) {
            if (inOrder.get(i) == preOrder.get(0)) {
                gen = i;
                break;
            }
        }
        // 前序：根左右   中序：左根右
        // 中序遍历 根节点左边的节点位于二叉树的左边，根节点右边位于二叉树的右边
        // 左子树
        for (int i = 0; i < gen; i++) {
            inLeft.add(inOrder.get(i)); //左子树前序为父代中序0-gen
            preLeft.add(preOrder.get(i + 1));  // 左子树中序为父代前序1-gen+1 (父代前序首节点为根)
        }

        // 右子树
        for (int i = gen + 1; i < length; i++) {
            inRight.add(inOrder.get(i));
            preRight.add(preOrder.get(i));
        }

        root.left = helper(preLeft, inLeft);
        root.right = helper(preRight, inRight);

        return root;
    }

    private TreeNode buildTree(int[] preOrder, int preLeft, int preRight,
                               int[] inOrder, int inLeft, int inRight) {
        // 终止条件
        if (preLeft > preRight || inLeft > inRight) return null;

        int pivot = preOrder[preLeft];
        TreeNode root = new TreeNode(pivot);

        int pivotIndex = inLeft;
        while (inOrder[pivotIndex] != pivot) {
            pivotIndex++;
        }

        root.left = buildTree(preOrder, preLeft + 1, pivotIndex - inLeft + preLeft,
                inOrder, inLeft, pivotIndex - 1);
        root.right = buildTree(preOrder, pivotIndex - inLeft + preLeft + 1, preRight,
                inOrder, pivotIndex + 1, inRight);

        return root;
    }
}
package top.wujinxing.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import top.wujinxing.leetcode.tree.*;

import java.util.List;

/**
 * @author wujinxing
 * @date 2023/3/7
 */
public class TreeTest {

    @Test
    public void preorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assert.assertEquals(Lists.newArrayList(1, 2, 3).toString(),
                Ch_144_BinaryTreePreorderTraversal.preorderTraversal(root).toString());
        Assert.assertEquals(Lists.newArrayList(1, 2, 3).toString(),
                Ch_144_BinaryTreePreorderTraversal.preorderTraversal2(root).toString());
    }

    @Test
    public void inorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assert.assertEquals(List.of(1, 3, 2), Ch_94_BinaryTreeInorderTraversal
                .inorderTraversal2(root));
        Assert.assertEquals(List.of(1, 3, 2), Ch_94_BinaryTreeInorderTraversal
                .inorderTraversal(root));
    }


    @Test
    public void postOrderTraversal() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Assert.assertEquals(List.of(3, 2, 1), Ch_145_BinaryTreePostorderTraversal
                .postOrderTraversal(root));
        Assert.assertEquals(List.of(3, 2, 1), Ch_145_BinaryTreePostorderTraversal
                .postOrderTraversal2(root));
        Assert.assertEquals(List.of(3, 2, 1), Ch_145_BinaryTreePostorderTraversal
                .postOrderTraversal3(root));
        Assert.assertEquals(List.of(3, 2, 1), Ch_145_BinaryTreePostorderTraversal
                .postOrderTraversal4(root));
    }

    @Test
    public void levelOrder() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15, 7)),
                Ch_102_BinaryTreeLevelOrderTraversal.levelOrder(root));
        Assert.assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15, 7)),
                Ch_102_BinaryTreeLevelOrderTraversal.levelOrder2(root));
    }

    @Test
    public void levelOrder2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertArrayEquals(new int[]{3, 9, 20, 15, 7}, Ch_32_SwordOffer_LevelOrder.levelOrder(root));
    }

    @Test
    public void levelOrder3() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(List.of(List.of(3), List.of(20, 9), List.of(15, 7)).toString(),
                Ch_32_SwordOffer_LevelOrder_III.levelOrder3(root).toString());
        Assert.assertEquals(List.of(List.of(3), List.of(20, 9), List.of(15, 7)).toString(),
                Ch_32_SwordOffer_LevelOrder_III.levelOrder3_2(root).toString());
    }

    @Test
    public void levelOrderBottom() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(List.of(List.of(15, 7), List.of(9, 20), List.of(3)),
                Ch_107_BinaryTreeLevelOrderTraversalII.levelOrderBottom(root));
    }

    @Test
    public void rightSideView() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        Assert.assertEquals(List.of(1, 3, 4), Ch_199_BinaryTreeRightSideView.rightSideView(root));
    }

    @Test
    public void averageLevels() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(List.of(3.0, 14.5, 11.0), Ch_637_AverageOfLevelsInBinaryTree.averageOfLevels(root));
    }

    @Test
    public void isSymmetric() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        Assert.assertTrue(Ch_101_SymmetricTree.isSymmetric(root));
        Assert.assertTrue(Ch_101_SymmetricTree.isSymmetric2(root));
    }

    @Test
    public void countNodes() {
        TreeNode root = TreeUtils.generate(new int[]{1, 2, 3, 4, 5, 6});
        TreeNode root2 = TreeUtils.generate(new int[]{});
        TreeNode root3 = TreeUtils.generate(new int[]{1});
        Assert.assertEquals(6, Ch_222_CountCompleteTreeNodes.countNodes(root));
        Assert.assertEquals(0, Ch_222_CountCompleteTreeNodes.countNodes(root2));
        Assert.assertEquals(1, Ch_222_CountCompleteTreeNodes.countNodes(root3));
        Assert.assertEquals(6, Ch_222_CountCompleteTreeNodes.countNodes2(root));
        Assert.assertEquals(0, Ch_222_CountCompleteTreeNodes.countNodes2(root2));
        Assert.assertEquals(1, Ch_222_CountCompleteTreeNodes.countNodes2(root3));
    }

    @Test
    public void isBalanced() {
        TreeNode root = TreeUtils.generate(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode root2 = TreeUtils.generate(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});
        Assert.assertTrue(Ch_110_Balanced_Binary_Tree.isBalanced(root));
        Assert.assertFalse(Ch_110_Balanced_Binary_Tree.isBalanced(root2));
        Assert.assertTrue(Ch_110_Balanced_Binary_Tree.isBalanced2(root));
        Assert.assertFalse(Ch_110_Balanced_Binary_Tree.isBalanced2(root2));
        TreeNode root3 = TreeUtils.generate(new Integer[]{0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8});
        Assert.assertFalse(Ch_110_Balanced_Binary_Tree.isBalanced(root3));
        Assert.assertFalse(Ch_110_Balanced_Binary_Tree.isBalanced2(root3));
    }


    @Test
    public void sumOfLeftLeaves() {
        TreeNode root = TreeUtils.generate(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode root2 = TreeUtils.generate(new Integer[]{3,9,20,null,null,15,7});
        Assert.assertEquals(10, Ch_404_Sum_of_Left_Leaves.sumOfLeftLeaves(root));
        Assert.assertEquals(24, Ch_404_Sum_of_Left_Leaves.sumOfLeftLeaves(root2));
    }

}

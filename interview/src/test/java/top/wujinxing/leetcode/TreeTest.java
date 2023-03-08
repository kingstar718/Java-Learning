package top.wujinxing.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import top.wujinxing.leetcode.tree.Ch_144_BinaryTreePreorderTraversal;
import top.wujinxing.leetcode.tree.Ch_145_BinaryTreePostorderTraversal;
import top.wujinxing.leetcode.tree.Ch_94_BinaryTreeInorderTraversal;
import top.wujinxing.leetcode.tree.TreeNode;

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

}

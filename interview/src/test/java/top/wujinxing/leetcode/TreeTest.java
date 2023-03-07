package top.wujinxing.leetcode;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import top.wujinxing.leetcode.tree.Ch_144_BinaryTreePreorderTraversal;
import top.wujinxing.leetcode.tree.TreeNode;

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
}

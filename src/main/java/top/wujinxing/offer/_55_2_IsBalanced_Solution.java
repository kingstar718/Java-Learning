package top.wujinxing.offer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/7/1 16:20
 * description 判断是否为平衡二叉树
 * 平衡二叉树左右子树高度差不超过 1。
 */
public class _55_2_IsBalanced_Solution {

    @Test
    public void test(){
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        TreeNode test = new TreeNode(0);
        test.left = a;
        test.right = a1;
        test.left.left = a2;
        test.left.left.left = a3;
        System.out.println(treeIsBalanced(test));
    }

    private boolean isBalanced = true;

    public boolean treeIsBalanced(TreeNode root){
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root){
        if (root==null || !isBalanced) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left-right)>1) isBalanced = false;
        return 1+Math.max(left, right);
    }
}

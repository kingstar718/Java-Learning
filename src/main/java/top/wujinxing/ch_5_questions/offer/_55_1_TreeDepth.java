package top.wujinxing.ch_5_questions.offer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/7/1 16:11
 * description 二叉树的深度
 *
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 */
public class _55_1_TreeDepth {

    @Test
    public void test(){
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(1);
        TreeNode test = new TreeNode(0);
        test.left = a;
        test.right = a1;
        test.left.left = a2;
        test.left.left.left = a3;
        System.out.println(TreeDepth(test));
    }

    public int TreeDepth(TreeNode root){
        //递归
        return root==null? 0: 1+Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}

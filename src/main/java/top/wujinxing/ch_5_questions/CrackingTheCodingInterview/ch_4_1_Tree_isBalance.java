package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

/**
 * @author wujinxing
 * date 2019 2019/8/18 21:28
 * description 二叉树平衡
 *
 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
 * 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */
public class ch_4_1_Tree_isBalance {

    private static boolean isBalance(TreeNode root) {
        if (root == null){
            return true;
        }else {
            int left = getDeep(root.left);
            int right = getDeep(root.right);
            if (Math.abs(left-right) <= 1){
                return isBalance(root.left) && isBalance(root.right); //递归
            }else {
                return false;
            }
        }
    }

    private static int getDeep(TreeNode root){
        if (root != null){
            int left = getDeep(root.left);
            int right = getDeep(root.right);
            return left> right? left+1: right+1;
        }else {
            return 0;
        }
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}

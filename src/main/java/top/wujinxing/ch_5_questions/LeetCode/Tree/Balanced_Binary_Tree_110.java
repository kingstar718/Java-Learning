package top.wujinxing.ch_5_questions.LeetCode.Tree;

/**
 * @ author: wujinxing
 * @ date: 2019/4/11 09:52
 * @ description: 平衡树左右子树高度差都小于等于 1
 */
public class Balanced_Binary_Tree_110 {
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if ((Math.abs(l - r) > 1)){
            result = false;
        }
        return 1 + Math.max(l, r);
    }
}

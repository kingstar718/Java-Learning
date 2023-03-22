package top.wujinxing.leetcode.tree;

/**
 * @author wujinxing
 * @date 2023/3/22
 *
 * <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/">530. 二叉搜索树的最小绝对差</a>
 */
public class Ch_530_MinimumAbsoluteDifferenceInBST {

    private TreeNode pre;
    private Integer res = Integer.MAX_VALUE;

    /**
     * 二叉搜索树的中序遍历是有序的。
     * 同样记录上一个遍历的节点，然后取和当前节点差值的最大值。
     */
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 左
        getMinimumDifference(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        // 右
        getMinimumDifference(root.right);
    }

}

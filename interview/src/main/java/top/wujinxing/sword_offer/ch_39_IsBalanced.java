package top.wujinxing.sword_offer;

/**
 * @author wujinxing
 * date 2019 2019/9/11 10:35
 * description 平衡二叉树
 * <p>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class ch_39_IsBalanced {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        return height(root) > -1;
    }

    //将求高度和平衡合并
    private static int height(TreeNode node) {
        if (node == null)
            return 0;
        int LH = height(node.left);
        int RH = height(node.right);
        if (Math.abs(LH - RH) > 1 || LH == -1 || RH == -1) {
            return -1;
        }
        return Math.max(LH, RH) + 1;
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

package top.wujinxing.sword_offer;

/**
 * @author wujinxing
 * date 2019 2019/9/4 21:20
 * description 二叉树的镜像
 * <p>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class ch_18_MirrorTree {

    //先把当前跟姐点的左右子树换掉
    //然后递归换自己的左右子树即可
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        Mirror(root.left);
        Mirror(root.right);
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

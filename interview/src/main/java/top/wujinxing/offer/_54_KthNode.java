package top.wujinxing.offer;

/**
 * @author wujinxing
 * date 2019 2019/7/2 11:08
 * description 二叉查找树的第k个节点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class _54_KthNode {
    private TreeNode ret;
    private int cnt = 0;
    public TreeNode KthNode(TreeNode pRoot, int k){
        inOrder(pRoot, k);
        return ret;
    }
    private void inOrder(TreeNode root, int k){
        if (root==null||cnt>=k) return;;
        inOrder(root.left, k);
        cnt++;
        if (cnt==k) ret = root;
        inOrder(root.right, k);
    }
}

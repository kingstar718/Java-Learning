package top.wujinxing.datastructure.tree;

/**
 * @author wujinxing
 * date 2019/9/21 10:32
 * description 二叉树基本结构
 * <p>
 * 避免反复重建
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

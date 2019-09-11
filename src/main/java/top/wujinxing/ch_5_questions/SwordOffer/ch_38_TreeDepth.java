package top.wujinxing.ch_5_questions.SwordOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujinxing
 * date 2019 2019/9/11 10:08
 * description 二叉树的深度
 * <p>
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class ch_38_TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    //层次遍历
    public int TreeDepth2(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0, nextLevelSize = 1;
        int depth = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            count++;
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            if (count == nextLevelSize) {
                count = 0;
                depth++;
                nextLevelSize = queue.size(); //下一层节点的个数
            }
        }
        return depth;
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

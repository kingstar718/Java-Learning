package top.wujinxing.ch_5_questions.SwordOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujinxing
 * date 2019 2019/9/7 21:18
 * description 从上往下打印二叉树
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class ch_22_PrintFromTopToBottom {

    /**
     * @param root TreeNode
     * @return ArrayList
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return list;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(PrintFromTopToBottom(root));
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

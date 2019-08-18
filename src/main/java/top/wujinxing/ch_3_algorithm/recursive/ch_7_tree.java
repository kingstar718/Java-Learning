package top.wujinxing.ch_3_algorithm.recursive;

import top.wujinxing.ch_5_questions.offer._55_1_TreeDepth;

/**
 * @author wujinxing
 * date 2019 2019/8/18 11:35
 * description 二叉树深度
 */
public class ch_7_tree {

    /**
     * 递归求二叉树深度
     * @param t
     * @return
     */
    public static int getTreeDepth(TreeNode t){
        if (t == null){
            return 0;
        }
        int left = getTreeDepth(t.left);
        int right = getTreeDepth(t.right);

        return left > right? left + 1 :right + 1;
    }

    public String preOrder(Node root){
        StringBuffer sb = new StringBuffer(); // 存到递归调用栈
        if (root == null){
            return "";
        }else {
            sb.append(root.data + ""); // 前序遍历当前结点
            sb.append(preOrder(root.left));// 前序遍历左子树
            sb.append(preOrder(root.right)); // 前序遍历右子树
            return sb.toString();
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
    static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        public Node(int data){
            this.data = data;
        }
    }
}

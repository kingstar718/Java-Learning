package top.wujinxing.ch_3_algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/9/4 8:42
 * description 之字形打印二叉树
 */
public class printTreeForZhi {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        System.out.println(print(tree));
    }

    private static ArrayList<ArrayList<Integer>> print(TreeNode tree) {
        //需要两个栈，打印某节点时，如果当前打印的是奇数层，先保存左子节点再保存右子节点到栈里
        //如果打印的是偶数层，则先保存右子节点，再保存左子节点到栈里
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (tree == null)
            return list;
        //存奇数层节点
        Stack<TreeNode> stack1 = new Stack<>();
        //存偶数层节点
        Stack<TreeNode> stack2 = new Stack<>();

        //初始
        int level = 1;
        stack1.push(tree);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> l = new ArrayList<>();

            //判断是哪一个栈进行出栈操作
            if (level % 2 == 1) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    l.add(node.val);
                    //进栈先左后右，出栈即先右后左
                    if (node.left != null) stack2.push(node.left);
                    if (node.right != null) stack2.push(node.right);
                }
                level++; //层数+1
                list.add(l);//将当前层加入大的list中
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    l.add(node.val);
                    if (node.right != null) stack1.push(node.right);
                    if (node.left != null) stack1.push(node.left);
                }
                level++;
                list.add(l);
            }
        }
        return list;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

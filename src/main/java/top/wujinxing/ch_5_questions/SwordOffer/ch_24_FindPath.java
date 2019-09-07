package top.wujinxing.ch_5_questions.SwordOffer;

import java.util.ArrayList;

/**
 * @author wujinxing
 * date 2019 2019/9/7 21:48
 * description 二叉树中和为某一值的路径
 * <p>
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的`list`中，数组长度大的数组靠前)
 */
public class ch_24_FindPath {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    /**
     * 思路:
     * 遍历到当前节点,每次先把当前节点加入到path中,并累加当前surSum += node.val,然后判断是否是叶子而且curSum == target
     * 如果没有达到目标,就递归左右子树
     * 如果到达了叶子且curSum == target, 就将中间结果path存到总结果res中,递归函数中path记得要回溯
     *
     * @param root   数
     * @param target 目标值
     * @return list
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return listAll;
        list.add(root.val); //将根节点的值加入list
        target -= root.val; //target的值减去了根节点的值
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
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

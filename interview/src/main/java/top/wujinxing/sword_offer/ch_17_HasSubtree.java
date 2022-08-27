package top.wujinxing.sword_offer;

/**
 * @author wujinxing
 * date 2019 2019/9/4 21:10
 * description 树的子结构
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class ch_17_HasSubtree {

    //- 先在`A`里面找到`B`的根的值(某个结点`A.val = B.val`)，然后看看子树是不是都相同(具体来说不是相同，而是`A`是否包含(`A>=B`))，
    //        这里判断是另一个函数`AcontainsB()`来判断；
    //- 如果上述条件不满足，递归在`A.left`或`A.right`中找这个值，然后再递归看子树是不是满足`AcontiansB`；
    //- 然后看递归函数函数`AcontainsB()`，递归条件`root2`只要达到空，就说明找到了，返回`true`，
    //         反之，`root1`达到空，返回`false`，注意这里不是判断两个树完全相等；
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        boolean res = false;
        if (root1.val == root2.val)
            res = aContainsB(root1, root2);
        if (!res)
            res = HasSubtree(root1.left, root2); //左边有可能包含root2
        if (!res)
            res = HasSubtree(root1.right, root2); //右边有可能包含root2
        return res;
    }

    //注意不是判断两棵树是不是完全相等，而是判断A是否包含B
    private boolean aContainsB(TreeNode A, TreeNode B) {
        if (B == null) //B遍历完成，说明可以
            return true;
        if (A == null)
            return false;
        //利用短路特性
        return A.val == B.val && aContainsB(A.left, B.left) && aContainsB(A.right, B.right);
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

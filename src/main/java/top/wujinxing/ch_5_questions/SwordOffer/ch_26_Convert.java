package top.wujinxing.ch_5_questions.SwordOffer;

import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/9/10 14:18
 * description 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ch_26_Convert {

    //- 改进中序非递归遍历(使用`pre`保存上一个访问的结点)，这个只要会非递归的中序遍历，其实是最简单的方法。
    //- 每次记录上一个访问的结点`pre`，然后每次当前结点为空(**访问到了最左边**)的时候，就设置`pre`和`cur`的关系即可；
    //- 这里使用了一个`isFirst`变量标注了一开始的节点，用`res`记录一开始的结点；

    public TreeNode Convert(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null, cur = root, res = null;
        boolean isFirst = true;
        while (!s.isEmpty() || cur != null) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                cur = s.pop();
                if (isFirst) {
                    isFirst = false;
                    res = cur;
                    pre = cur;
                } else {
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }
                cur = cur.right;
            }
        }
        return res;
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

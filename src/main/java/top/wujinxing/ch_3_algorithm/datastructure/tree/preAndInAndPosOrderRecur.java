package top.wujinxing.ch_3_algorithm.datastructure.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wujinxing
 * date 2019/9/21 10:34
 * description 用递归和非递归方式实现二叉树的先序、中序、后序遍历
 * <p>
 * 先序：根左右
 * 中序：左根右
 * 后序：左右根
 */
public class preAndInAndPosOrderRecur {

    //递归先序
    private void preOrderRecur(TreeNode head) {
        if (head == null)
            return;
        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //递归中序
    private void inOrderRecur(TreeNode head) {
        if (head == null)
            return;
        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }

    //递归后序
    private void posOrderRecur(TreeNode head) {
        if (head == null)
            return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.val + " ");
    }

    /**
     * 递归前序
     * 1.stack，将头结点压入stack
     * 2.弹出栈顶结点，记为cur，打印cur的值，再将cur的右节点压入（不为空的话），再将左节点（不为空的话）压入stack
     * 3.不断重复2，直到stack为空  。
     */
    private void preOrderUnRecur(TreeNode head) {
        System.out.print(" pre-order:");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归中序
     * 1.申请一个栈stack，初试时令变量cur = head
     * 2.将cur节点压入栈中，依次把左边界压入栈中，即不停令cur = cur.left，然后重复步骤2
     * 3.不停重复步骤2，直到cur为空，此时从stack弹出一个节点，记为node，打印node的值并让cur = cur.right，然后继续2
     * 4.当stack为空时，整个过程停止
     */
    private void inOrderUnRecur(TreeNode head) {
        System.out.print(" in-order:");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归后序遍历
     * 1.栈s1将头结点压入s1中
     * 2.s1中弹出的节点记为cur，依次将cur的左孩子节点和右孩子节点压入s1中
     * 3.在整个过程中，每一个从s1中弹出的节点都放入s2中
     * 4.不断重复2，3，直到s1为空，过程停止
     */
    private void posOrderUnRecur(TreeNode head) {
        System.out.print(" pos-order:");
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }
        System.out.println();
    }

    @Test
    public void test() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        /**
         *       1
         *      / \
         *     2   3
         *    / \ / \
         *   4  5 6  7
         */
        //1 2 4 5 3 6 7  pre-order:1 2 4 5 3 6 7
        preOrderRecur(head);
        preOrderUnRecur(head);
        System.out.println();
        //4 2 5 1 6 3 7  in-order:4 2 5 1 6 3 7
        inOrderRecur(head);
        inOrderUnRecur(head);
        System.out.println();
        //4 5 2 6 7 3 1  pos-order:4 5 2 6 7 3 1
        posOrderRecur(head);
        posOrderUnRecur(head);
    }

}

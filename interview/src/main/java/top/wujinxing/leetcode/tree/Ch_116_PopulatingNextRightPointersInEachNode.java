package top.wujinxing.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujinxing
 * @date 2023/3/14
 * </p>
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/">116. 填充每个节点的下一个右侧节点指针</a>
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Ch_116_PopulatingNextRightPointersInEachNode {


    /**
     * 增加一个变量来表示前一个节点，让前一个节点的next指向当前节点。
     */
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            // 前一个节点
            Node pre = null;
            for (int i = 0; i < queueSize; i++) {
                Node curr = queue.poll();
                // 每层的第一节点
                if (i == 0) {
                    pre = curr;
                }
                // 让前一个的左边节点的next指向当前节点
                if (i > 0) {
                    pre.next = curr;
                    pre = curr;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }
}

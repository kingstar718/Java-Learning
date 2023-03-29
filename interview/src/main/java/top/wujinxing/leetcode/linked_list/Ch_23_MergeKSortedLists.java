package top.wujinxing.leetcode.linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujinxing
 * @date 2023/3/29
 * </p>
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/">23. Merge k Sorted Lists</a>
 */
public class Ch_23_MergeKSortedLists {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, Comparator.comparingInt(a -> a.val)
        );
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            // 获取最小结点，街道结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }
}

package top.wujinxing.leetcode.linked_list;

/**
 * @author wujinxing
 * @date 2019/12/30 17:52
 * update 2023-3-31 17:38:24
 * description 删除链表中倒数第n个节点
 */
public class Ch_19_RemoveNthNodeFromEndofList {

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        // p2需要提前一位
        ListNode p2 = dummy;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }

    /**
     * 这个方法暂时不能解决  head=[1] n=1
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 删除倒数第n个，要先找到倒数第n+1个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第n个节点
        x.next = x.next.next;
        return dummy.next;
    }

    /**
     * 这题涉及到一个问题：单链表的倒数第k个节点
     */
    public static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1先走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1和p2同时走 n-k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

}

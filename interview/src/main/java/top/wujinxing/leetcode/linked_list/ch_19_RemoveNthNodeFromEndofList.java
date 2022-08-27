package top.wujinxing.leetcode.linked_list;

/**
 * @author wujinxing
 * date 2019 2019/12/30 17:52
 * description 删除链表中倒数第n个节点
 */
public class ch_19_RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // 移动 n+1 次
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}

package top.wujinxing.leetcode.labuladong;


import top.wujinxing.ListNode;

/**
 * 删除排序链表中的重复元素
 *
 * @author wujinxing
 */
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 断开与后边重复元素的链接
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.convert(new int[]{1, 1, 2, 3, 3});
        ListNode.print(head);
        ListNode listNode = deleteDuplicates(head);
        ListNode.print(listNode);
    }

}


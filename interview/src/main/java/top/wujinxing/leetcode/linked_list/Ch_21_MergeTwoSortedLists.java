package top.wujinxing.leetcode.linked_list;

/**
 * @author wujinxing
 * @date 2019 2019/12/30 17:25
 * description 合并两个有序链表
 * </p>
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/submissions/">21. 合并两个有序链表</a>
 */
public class Ch_21_MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

}

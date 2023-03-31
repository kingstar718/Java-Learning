package top.wujinxing.leetcode.linked_list;

/**
 * @author kingstar718
 * @date 2023-3-31
 * <p>
 * 单链表的分解：https://leetcode.cn/problems/partition-list/
 * <p>
 * 给定一个链表的头节点head和一个特定值x，分隔链表，使得所有小于x的节点都出现在大于等于x的节点之前
 * <p>
 * 应当保留两个分区中每个节点的相对位置
 */
public class Ch_89_PartitonLinkedList {
    
    public static ListNode partition(ListNode head, int x) {
        ListNode lower = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        // p1 p2 指针负责生成结果链表
        ListNode p1 = lower;
        ListNode p2 = greater;
        // p负责遍历原链表，类似合并两个有序链表的逻辑
        // 这里是将一个链表分解成两个链表
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            // 断开原链表中的每个节点的next指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        // 连接两个链表
        p1.next = greater.next;
        return lower.next;
    }

}

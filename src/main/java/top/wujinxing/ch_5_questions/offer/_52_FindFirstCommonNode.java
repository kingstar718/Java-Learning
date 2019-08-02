package top.wujinxing.ch_5_questions.offer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/7/1 15:29
 * description 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共结点。
 *      a1->a2->
 *              c1->c2->c3
 *  b1->b2->b3->
 *  设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 * 当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
 * 同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
 * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 */
public class _52_FindFirstCommonNode {

    @Test
    public void test(){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);

        ListNode A = a1;
        A.next = a2;
        A.next.next = c1;
        A.next.next.next = c2;
        ListNode B = b1;
        B.next = b2;
        B.next.next = b3;
        B.next.next = c1;
        B.next.next.next = c2;
        System.out.println(FindFirstCommonNode(A, B).val + " " + FindFirstCommonNode(A, B).next.val);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2){
            l1 = (l1==null)? pHead2: l1.next;
            l2 = (l2==null)? pHead1: l2.next;
        }
        return l1;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

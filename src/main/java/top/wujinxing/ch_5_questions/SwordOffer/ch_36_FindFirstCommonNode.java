package top.wujinxing.ch_5_questions.SwordOffer;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author wujinxing
 * date 2019 2019/9/11 9:36
 * description 两个链表的第一个公共节点
 * <p>
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class ch_36_FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        for (ListNode cur = pHead1; cur != null; cur = cur.next)
            set.add(cur);
        for (ListNode cur = pHead2; cur != null; cur = cur.next)
            if (set.contains(cur))
                return cur;
        return null;
    }

    //设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
    // * 当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
    // * 同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
    // * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null) ? pHead2 : p1.next;
            p2 = (p2 == null) ? pHead1 : p2.next;
        }
        return p1;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test(){
        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);
        p1.next = new ListNode(1);
        p2.next = new ListNode(1);
        p1.next.next = new ListNode(2);
        p2.next.next = new ListNode(2);
        ListNode common = new ListNode(3);
        p1.next.next.next = common;
        p2.next.next.next = new ListNode(4);
        p2.next.next.next.next = common;
        System.out.println(FindFirstCommonNode(p1, p2).val);
        System.out.println(FindFirstCommonNode2(p1, p2).val);

    }
}

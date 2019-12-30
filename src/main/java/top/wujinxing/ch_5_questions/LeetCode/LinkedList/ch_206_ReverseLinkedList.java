package top.wujinxing.ch_5_questions.LeetCode.LinkedList;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/3/3 20:43
 * @description:    反转链表
 * Reverse a singly linked list.
 *
 * Example: *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ch_206_ReverseLinkedList {
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseList3(ListNode head) {
        if (head ==null || head.next == null)
            return head;

        ListNode temp = head.next;
        ListNode newHead = reverseList3(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }


    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //LinkedListTool.print(head);
        ListNode reHead = reverseList(head);
        LinkedListTool.print(reHead);
    }
}
package top.wujinxing.ch_5_questions.codetop;

import org.junit.Test;

/**
 * @author wujinxing
 */
public class Ch206ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(l1);
        ListNode l2 = reverseList(l1);
        System.out.println(l2);
    }
}

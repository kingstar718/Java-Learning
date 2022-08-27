package top.wujinxing.leetcode.linked_list;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/12/30 19:17
 * description
 */
public class LinkedListTool {

    public static void print(ListNode list){
        if (list == null){
            System.out.println("List is null");
        }
        ListNode test = list;
        while (test != null){
            System.out.print(test.val + "->");
            test = test.next;
        }
        System.out.print("null\n");
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        LinkedListTool.print(head);
        LinkedListTool.print(head);
    }
}

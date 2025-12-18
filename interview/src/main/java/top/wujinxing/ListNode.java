package top.wujinxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujinxing
 * @date 2025/5/13
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static ListNode convert(int[] array) {
        ListNode p = new ListNode(1);
        ListNode r = p;
        for (int a : array) {
            r.next = new ListNode(a);
            r = r.next;
        }
        return p.next;
    }

}

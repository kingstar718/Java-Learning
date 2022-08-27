package top.wujinxing.sword_offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/8/29 13:46
 * description 从头到尾打印链表
 * <p>
 * 输入一个链表的头结点，按链表值从尾到头的顺序返回一个ArrayList。
 * <p>
 * 可以用栈，也可以递归。
 */
public class ch_03_printListFromTailToHead {

    //递归实现
    private List<Integer> printListFromTailToHead(ListNode listNode) {
        List<Integer> res = new ArrayList<>();
        rec(listNode, res);
        return res;
    }

    private void rec(ListNode cur, List<Integer> list) {
        if (cur == null) {//递归终止条件
            return;
        }
        rec(cur.next, list);
        list.add(cur.val);
    }

    //栈实现
    private List<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(6);
        list.next.next.next.next = new ListNode(5);

        System.out.println(printListFromTailToHead(list));
        System.out.println(printListFromTailToHead2(list));
    }
}

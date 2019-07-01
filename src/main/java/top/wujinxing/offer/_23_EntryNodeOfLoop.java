package top.wujinxing.offer;

import org.junit.Test;

import java.awt.*;

/**
 * @author wujinxing
 * date 2019 2019/7/1 22:13
 * description 链表中的环的入口节点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 使用双指针，一个指针 fast 每次移动两个节点，一个指针 slow 每次移动一个节点。
 * 因为存在环，所以两个指针必定相遇在环中的某个节点上。
 * 假设相遇点在下图的 z1 位置，此时 fast 移动的节点数为 x+2y+z，slow 为 x+y，
 * 由于 fast速度比 slow 快一倍，因此 x+2y+z=2(x+y)，得到 x=z。
 * 在相遇点，slow 要到环的入口点还需要移动 z 个节点，如果让 fast 重新从头开始移动，
 * 并且速度变为每次移动一个节点，那么它到环入口点还需要移动 x 个节点。
 * 在上面已经推导出 x=z，因此 fast 和 slow 将在环入口点相遇。
 */
public class _23_EntryNodeOfLoop {
    @Test
    public void test(){
        ListNode x1 = new ListNode(1);
        ListNode x2 = new ListNode(2);
        ListNode x3 = new ListNode(3);
        ListNode x4 = new ListNode(4);
        ListNode x5 = new ListNode(5);
        ListNode x6 = new ListNode(6);
        ListNode x7 = new ListNode(7);
        ListNode x8 = new ListNode(8);
        ListNode x9 = new ListNode(9);
        ListNode x10 = new ListNode(10);
        ListNode test = x1;
        test.next = x2;
        test.next.next = x3;
        x3.next = x4;
        x4.next = x5;
        x5.next = x6;
        x6.next = x7;
        x7.next = x8;
        x8.next = x9;
        x9.next = x10;
        x10.next = x3; //环入口为3
        System.out.println(EntryNodeOfLoop(test).val);

    }

    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead==null || pHead.next==null) return null;
        ListNode slow = pHead, fast = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        }while (slow != fast);
        fast = pHead;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

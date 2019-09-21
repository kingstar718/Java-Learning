package top.wujinxing.ch_3_algorithm.datastructure.linkedlist;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/9/4 12:38
 * description 反转单向链表和双向链表
 * <p>
 * 要求时间复杂度为`O(N)`，额外空间复杂度为`O(1)`
 * 此题的难点就是反转一个结点的 next 指针后，就无法在该结点通过 next 指针找到后续的结点了。
 * 因此每次反转之前需要将该结点的后继结点记录下来。
 */
public class ch_2_reverseList {

    //反转单链表
    private Node reverse_List(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next; //next指向head下一个节点
            head.next = pre; //令pre指向head的next
            pre = head; //pre指向head
            head = next; //head指向next(实际就是使用next让head前进)
        }
        return pre;
    }

    //反转双向链表
    private DoubleNode reverse_List(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转部分列表
     * 1->2->3->4->5->null  from=2 to=4
     * return: 1->4->3->2->5->null
     */
    private Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len)
            return head;
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }

    public static void print(Node node) {
        Node cur = node;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void print(DoubleNode node) {
        DoubleNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Test
    public void test() {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        print(head);
        print(reverse_List(head));

        DoubleNode DNode = new DoubleNode(0);
        DoubleNode DNode2 = new DoubleNode(1);
        DoubleNode DNode3 = new DoubleNode(2);
        DoubleNode DNode4 = new DoubleNode(3);
        DoubleNode DNode5 = new DoubleNode(4);
        DNode.next = DNode2;
        DNode2.last = DNode;
        DNode2.next = DNode3;
        DNode3.last = DNode2;
        DNode3.next = DNode4;
        DNode4.last = DNode3;
        DNode4.next = DNode5;
        DNode5.last = DNode4;
        print(DNode);
        print(reverse_List(DNode));

        print(reversePart(head, 2,4));
    }
}

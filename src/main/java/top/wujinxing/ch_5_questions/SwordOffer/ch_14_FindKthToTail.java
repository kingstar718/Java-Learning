package top.wujinxing.ch_5_questions.SwordOffer;

/**
 * @author wujinxing
 * date 2019 2019/9/4 19:47
 * description 链表中倒数第k个结点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class ch_14_FindKthToTail {

    //双指针 先设置两个指针一开始都指向head
    //第一个指针first走k-1步 然后两个指针一起走，当第一个指针first走到末尾时(second.nezt=null)
    //第二个指针second就刚好指向倒数第k个结点
    public ListNode FindKthToTailII(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k - 1; i++) { //注意条件k-1
            first = first.next;
        }
        if (first == null) return null;  //注意条件 没有报错
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }


    //常规思路 1.先遍历一遍链表求出链表长度 2,。从头开始走len-k个结点就可以到倒数第k个结点
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        if (k > len) {
            return null;
        }
        cur = head;
        for (int i = 0; i < len - k; i++) {
            cur = cur.next;
        }
        return cur;
    }


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

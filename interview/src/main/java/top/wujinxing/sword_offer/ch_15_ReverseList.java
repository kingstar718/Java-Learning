package top.wujinxing.sword_offer;

/**
 * @author wujinxing
 * date 2019 2019/9/4 20:23
 * description 反转链表
 * <p>
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ch_15_ReverseList {

    //很经典的翻转链表的题目，使用pre、next指针，pre指向当前cur的前一个，next是当前cur的下一个指针；
    //然后每次都改变cur的next为pre，循环递推，直到cur = null，最后返回pre；

    /**
     * 第一轮
     * cur(0)->1->2->3->null
     * next(1)->2->3->null   next = cur.next;
     * cur(0)->null;         cur.next = pre;
     * pre(0)->null;         pre = cur;
     * cur(1)->2->3->null    cur = next;
     * 第二轮
     * next(2)->3->null;    next = cur.next;
     * cur(1)->0->null;     cur.next = pre;
     * pre(1)->0->null;     pre = cur;
     * cur(2)->3->null;     cur = next;
     * 可以看出pre保存了反转的链表
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, cur = head, next;
        while (cur != null) {
            next = cur.next; //用next保存下一个结点信息
            cur.next = pre;  // 反转
            pre = cur;
            cur = next;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}

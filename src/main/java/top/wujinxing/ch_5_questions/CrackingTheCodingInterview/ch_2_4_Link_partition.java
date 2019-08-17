package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

/**
 * @author wujinxing
 * date 2019 2019/8/17 10:48
 * description 链表分割
 *
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */
public class ch_2_4_Link_partition {

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        ListNode p2 = new ListNode(2);

        p.next = p2;//p的下一个节点是p2
        p = p.next;//相当于从链表中删掉了p p是头结点，此时p2成为头结点但变量名是p，
        System.out.println();
    }

    private static ListNode partition(ListNode pHead, int x){

        if (pHead==null) return pHead;

        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        //p1 p2 实际上是移动节点
        ListNode p1 = dummyHead1;
        ListNode p2 = dummyHead2;

        while (pHead != null) {
            if (pHead.val < x) {
                p1.next = pHead;
                p1 = p1.next;
            }
            else {
                p2.next = pHead;
                p2 = p2.next;
            }
            pHead = pHead.next;//此时的pHead也是在移动，相当于删除前一个节点
        }
        p2.next = null;// prevent [x+1, x-1, x-2]
        p1.next = dummyHead2.next;

        return dummyHead1.next;
    }

    private static ListNode partition2(ListNode pHead, int x) {
        if (pHead==null) return pHead;

        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode smallHead = small;

        //分别设置头指针指向两个链表的首节点
        ListNode bigHead = big;
        ListNode curNode = pHead;

        while (curNode!=null){
            if (curNode.val<x){
                small.next = curNode;
                small = small.next;
            }else {
                big.next = curNode;
                big = big.next;
            }
            curNode = curNode.next;
        }
        //small链表最后一个节点指向big的头指针，即bigHead
        small.next = bigHead.next;
        //big链表最后一个节点设置为尾节点，即设置为null
        big.next = null;

        return smallHead.next;
    }
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}




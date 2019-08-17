package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

/**
 * @author wujinxing
 * date 2019 2019/8/17 9:53
 * description 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class ch_2_2_Link_FindKthToTail {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(FindKthToTail(head,2));
        System.out.println(FindKthToTail3(head, 2));
    }

    //方法1
    private static ListNode FindKthToTail(ListNode head,int k) {
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p!=null; i++){
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null: q;
    }
    //方法2
    private static ListNode FindKthToTail2(ListNode head,int k) {
        ListNode pre, p;
        pre = p = head;//两个指针都指向头结点
        int a = k;//记录k值
        int count = 0;//记录节点的个数
        //p指针先跑，并且记录节点数，当p指针跑了k-1个节点后，pre指针开始跑，
        //当p指针跑到最后时，pre所指指针就是倒数第k个节点
        while (p!=null){
            p = p.next;
            count++;
            if (k<1)
                pre = pre.next;
            k--;
        }
        //如果节点个数小于所求的倒数第k个节点，则返回空
        if (count<a) return null;
        return pre;
    }

    //自己的方法
    private static ListNode FindKthToTail3(ListNode head,int k) {
        if (head==null) return head; //注意条件
        int count = 1;
        ListNode temp = head;
        while (temp.next!=null){
            count++;
            temp = temp.next;
        }
        int m = count-k;
        if (m<0) return null; //注意条件
        ListNode node = head;
        for (int i=0; i<m; i++){
            node = node.next;
        }
        return node;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

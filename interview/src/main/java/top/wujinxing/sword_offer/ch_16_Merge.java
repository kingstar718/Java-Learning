package top.wujinxing.sword_offer;

/**
 * @author wujinxing
 * date 2019 2019/9/4 20:45
 * description 合并两个排序的链表
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class ch_16_Merge {

    //使用类似合并有序数组的方法，外排(归并排序中最后合并的方式)的方式(那个小就先加哪一个)；
    //但是这里要注意我这里设置了一个虚拟的头结点，这样的话方便第一个结点的添加和判断
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode p1 = list1, p2 = list2;
        ListNode dummyHead = new ListNode(-1);
        ListNode p3 = dummyHead;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        //后面的直接连上，不需要用while
        if (p1 != null) {
            p3.next = p1;
        }
        if (p2 != null) {
            p3.next = p2;
        }
        return dummyHead.next; //虚拟头结点的下一个
    }

    //递归
    public ListNode mergeII(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode curHead;
        if (list1.val < list2.val) {
            curHead = list1;
            curHead.next = mergeII(list1.next, list2);
        } else {
            curHead = list2;
            curHead.next = mergeII(list1, list2.next);
        }
        return curHead;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

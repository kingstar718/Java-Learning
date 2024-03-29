package top.wujinxing.offer;

/**
 * @author: wujinxing
 * @date: 2019/3/18 22:39
 * @description:
 */
public class LinkedListMerge {

    public ListNode Merge(ListNode list1, ListNode list2){
        if (list1==null) return list2;
        if (list2==null) return list1;

        if (list1.val<=list2.val){
            list1.next = Merge(list1.next,list2);
            return list1;
        }else {
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }

    public ListNode Merge2(ListNode list1, ListNode list2){
        if (list1==null) return list2;
        if (list2==null) return list1;

        ListNode mergeHead = null;
        ListNode current = null;
        while (list1!=null&&list2!=null){
            if (list1.val<=list2.val){
                if (mergeHead==null){
                    mergeHead = current = list1;
                }else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else {
                if (mergeHead==null){
                    mergeHead = current = list2;
                }else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if (list1==null){
            current.next = list2;
        }else {
            current.next = list1;
        }
        return mergeHead;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
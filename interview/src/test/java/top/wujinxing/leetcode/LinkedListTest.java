package top.wujinxing.leetcode;

import org.junit.Assert;
import org.junit.Test;
import top.wujinxing.leetcode.linked_list.Ch_21_MergeTwoSortedLists;
import top.wujinxing.leetcode.linked_list.ListNode;

/**
 * @author wujinxing
 * @date 2023/3/29
 */
public class LinkedListTest {

    @Test
    public void mergeTwoSorted() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Assert.assertEquals("[1,1,2,3,4,4]", Ch_21_MergeTwoSortedLists.mergeTwoLists(l1, l2).serialize());
    }

}

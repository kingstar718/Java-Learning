package top.wujinxing.leetcode;

import org.junit.Assert;
import org.junit.Test;
import top.wujinxing.leetcode.linked_list.Ch_21_MergeTwoSortedLists;
import top.wujinxing.leetcode.linked_list.Ch_23_MergeKSortedLists;
import top.wujinxing.leetcode.linked_list.ListNode;

/**
 * @author wujinxing
 * @date 2023/3/29
 */
public class LinkedListTest {

    @Test
    public void mergeTwoSorted() {
        ListNode l1 = ListNode.deserialize("[1,2,4]");
        ListNode l2 = ListNode.deserialize("[1,3,4]");
        Assert.assertEquals("[1,1,2,3,4,4]", Ch_21_MergeTwoSortedLists.mergeTwoLists(l1, l2).serialize());
    }

    @Test
    public void mergeKLists() {
        ListNode[] lists = new ListNode[]{
                ListNode.deserialize("[1,4,5]"),
                ListNode.deserialize("[1,3,4]"),
                ListNode.deserialize("[2,6]")
        };
        Assert.assertEquals("[1,1,2,3,4,4,5,6]", Ch_23_MergeKSortedLists.mergeKLists(lists).serialize());
    }

}

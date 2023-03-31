package top.wujinxing.leetcode;

import org.junit.Assert;
import org.junit.Test;

import top.wujinxing.leetcode.linked_list.Ch_19_RemoveNthNodeFromEndofList;
import top.wujinxing.leetcode.linked_list.Ch_21_MergeTwoSortedLists;
import top.wujinxing.leetcode.linked_list.Ch_23_MergeKSortedLists;
import top.wujinxing.leetcode.linked_list.Ch_876_MiddleoftheLinkedList;
import top.wujinxing.leetcode.linked_list.Ch_86_PartitionLinkedList;
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

    @Test
    public void findFromEnd() {
        ListNode head = ListNode.deserialize("[1,2,3,4,5,6,7]");
        Assert.assertEquals(5, Ch_19_RemoveNthNodeFromEndofList.findFromEnd(head, 3).val);
    }

    @Test
    public void removeNthFromEnd() {
        ListNode head = ListNode.deserialize("[1,2,3,4,5]");
        ListNode result = ListNode.deserialize("[1,2,3,5]");
        ListNode head2 = ListNode.deserialize("[1]");
        Assert.assertEquals(result.serialize(), Ch_19_RemoveNthNodeFromEndofList.removeNthFromEnd(head, 2).serialize());
        Assert.assertEquals("[]", ListNode.serialize(Ch_19_RemoveNthNodeFromEndofList.removeNthFromEnd2(head2, 1)));
    }

    @Test
    public void partition() {
        ListNode head = ListNode.deserialize("[1,4,3,2,5,2]");
        Assert.assertEquals("[1,2,2,4,3,5]", Ch_86_PartitionLinkedList.partition(head, 3).serialize());
    }

    @Test
    public void middleNode() {
        ListNode head = ListNode.deserialize("[1,2,3,4,5]");
        ListNode head2 = ListNode.deserialize("[1,2,3,4,5,6]");
        Assert.assertEquals(3, Ch_876_MiddleoftheLinkedList.middleNode(head).val);
        Assert.assertEquals(4, Ch_876_MiddleoftheLinkedList.middleNode(head2).val);
        Assert.assertEquals(3, Ch_876_MiddleoftheLinkedList.middleNode2(head).val);
        Assert.assertEquals(4, Ch_876_MiddleoftheLinkedList.middleNode2(head2).val);
    }

}

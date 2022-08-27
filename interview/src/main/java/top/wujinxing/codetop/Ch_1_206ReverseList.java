package top.wujinxing.codetop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wujinxing
 */
@Slf4j
public class Ch_1_206ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 先存储下一个节点
            ListNode nextNode = curr.next;
            // 将当前节点的下一个指向前一个
            curr.next = prev;
            // 将前一个移到当前节点
            prev = curr;
            // 将当前节点移到下一节点
            curr = nextNode;
        }
        return prev;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1, 2, 3, 4, 5, 6, 7, 8, 9);
        log.info("prev list: {}", l1);
        ListNode l2 = reverseList(l1);
        log.info("reverse link list: {}", l2);
    }
}

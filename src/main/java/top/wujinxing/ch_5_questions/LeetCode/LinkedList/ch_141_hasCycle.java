package top.wujinxing.ch_5_questions.LeetCode.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujinxing
 * date 2019 2019/9/27 11:06
 * description 判断链表中是否有环
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 */
public class ch_141_hasCycle {

    /**
     * 一个快指针fast，一个慢指针，快指针一次向前走两个节点，
     * 慢指针一次走一个节点，如果出现fast == slow的情况，说明链表中有环。
     * 注意：
     * - 初始判断：`if (head == bull || head. next == null )`，直接返回false；
     * - 循环时，判断fast指针是否已经走到链表末尾，不能只判断 `fast.next != null`，
     * 而是要判断 `fast != null && fast.next != null`，否则当 `fast.next == null时`，会出现空指针异常。
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }

        return false;
    }
}

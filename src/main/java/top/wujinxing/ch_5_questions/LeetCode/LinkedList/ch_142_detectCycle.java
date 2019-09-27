package top.wujinxing.ch_5_questions.LeetCode.LinkedList;

/**
 * @author wujinxing
 * date 2019 2019/9/27 11:14
 * description 返回链表开始入环的第一个节点
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * 进阶：你是否可以不用额外空间解决此题？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 */
public class ch_142_detectCycle {

    /**
     * 思路和上一题一样，就是在出现环时，即`fast == slow`时，需要找到环的出口位置并返回，寻找出口点的算法如下：
     * ```java
     * while (head != slow) {
     * head = head.next;
     * slow = slow.next;
     * }
     * return slow;
     * ```
     * 也就是说，当`fast == slow` 时，slow和fast以相同的速度向前移动，最终它们会在环的入口位置相遇。
     *
     * @param head 链表头结点
     * @return 入环节点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}

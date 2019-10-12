package top.wujinxing.ch_5_questions.LeetCode.LinkedList;

/**
 * @author wujinxing
 * date 2019 2019/10/12 21:45
 * description
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 */
public class ch_234_Palindrome_LinkedList {
    public boolean isPalindrome(ListNode head) {
        /**
         *快慢指针找到链表的中点
         *翻转链表的前半部分
         *回文校验
         */
        if (head == null || head.next == null) return true;

        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;
        ListNode next = null;
        while (head != slow) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        //如果是奇数个节点，去掉后半部分的节点
        if (fast != null)
            slow = slow.next;

        //回文校验
        while (pre != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }
}

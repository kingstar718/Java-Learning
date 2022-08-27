package top.wujinxing.cracking_the_coding_interview;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujinxing
 * date 2019 2019/8/17 15:48
 * description 回文链表
 *
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 */
public class ch_2_6_Link_isPalindrome {

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        p.next = new ListNode(2);
        p.next.next = new ListNode(3);
        System.out.println(isPalindrome(p));
    }

    private static boolean isPalindrome(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        //因为集成自Vector，所以Stack类是同步的，效率不高。官方一般建议这样使用ArrayDeque代替Stack
        //Stack<Integer> stack = new Stack<>();  //不推荐使用
        Deque<Integer> deque = new ArrayDeque<>();


        /**
         * 将链表的前半部分元素装入栈中，当快速runner
         *（移动的速度是慢速runner的两倍）
         * 到底链表尾部时，则慢速runner已经处于链表中间位置
         */
        while (fast!=null && fast.next!=null){
            deque.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        //当链表为奇数个时，跳过中间元素
        if (fast!=null){
            slow = slow.next;
        }
        while (slow!=null){
            //如果两者不相同，则该链表不是回文串
            if (deque.pop() != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

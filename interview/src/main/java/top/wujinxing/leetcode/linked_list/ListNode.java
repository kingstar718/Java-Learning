package top.wujinxing.leetcode.linked_list;

/**
 * @author wujinxing
 * date 2019 2019/9/27 11:11
 * description 链表节点类
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public String serialize() {
        StringBuilder sb = new StringBuilder("[");
        ListNode p = this;
        while (p != null) {
            sb.append(p.val).append(",");
            p = p.next;
        }
        return sb.substring(0, sb.length() - 1) + "]";
    }

}

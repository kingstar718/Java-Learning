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

    public static String serialize(ListNode head) {
        if (head == null) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder("[");
        ListNode p = head;
        while (p != null) {
            sb.append(p.val).append(",");
            p = p.next;
        }
        return sb.substring(0, sb.length() - 1) + "]";
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

    private static final String EMPTY = "[]";
    private static final String BLACK = "";

    public static ListNode deserialize(String data) {
        if (data == null || BLACK.equals(data) || EMPTY.equals(data)) {
            return null;
        }
        String[] array = data.substring(1, data.length() - 1).split(",");
        ListNode res = new ListNode(-1);
        ListNode p = res;
        for (String s : array) {
            p.next = new ListNode(Integer.parseInt(s));
            p = p.next;
        }
        return res.next;
    }

}

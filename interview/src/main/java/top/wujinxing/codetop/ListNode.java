package top.wujinxing.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * @author wujinxing
 * @date 2021-12-05
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int... values) {
        List<ListNode> list = new ArrayList<>();
        for (int i : values) {
            list.add(new ListNode(i));
        }
        for (int i = 0; i < values.length - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        this.val = list.get(0).val;
        this.next = list.get(0).next;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        ListNode curr = this;
        while (curr != null) {
            out.append(curr.val).append(",");
            curr = curr.next;
        }
        return out.substring(0, out.length() - 1) + "]";
    }
}

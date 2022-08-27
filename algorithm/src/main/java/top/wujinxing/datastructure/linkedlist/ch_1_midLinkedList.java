package top.wujinxing.datastructure.linkedlist;

/**
 * @author wujinxing
 * date 2019 2019/9/4 12:40
 * description 单链表的中间节点
 */
public class ch_1_midLinkedList {

    public static void main(String[] args) {
        Node linkedList = new Node(1);
        linkedList.next = new Node(2);
        linkedList.next.next = new Node(3);
        linkedList.next.next.next = new Node(4);
        linkedList.next.next.next.next = new Node(5);
        linkedList.next.next.next.next.next = new Node(6);
        linkedList.next.next.next.next.next.next = new Node(7);

        System.out.println(printMid(linkedList));
    }

    private static int printMid(Node list) {
        Node low = list;
        Node fast = list;

        while (fast != null) {
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                break;
            }
            low = low.next;
        }
        return low.val;
    }

    static class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }
}

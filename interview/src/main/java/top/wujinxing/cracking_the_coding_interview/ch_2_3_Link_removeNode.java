package top.wujinxing.cracking_the_coding_interview;

/**
 * @author wujinxing
 * date 2019 2019/8/17 10:36
 * description 访问单个节点的删除
 *
 * 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 给定待删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 */
public class ch_2_3_Link_removeNode {

    private static boolean removeNode(ListNode pNode) {
        if (pNode.next==null || pNode==null) {
            return false;
        }else {
            //假设pNode的前一个节点是pPre，其实pPre.next = pNode
            //那么下面这句实际上就是 pPre.next = pNode.next, 实际上是删除了pNode
            pNode = pNode.next;
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

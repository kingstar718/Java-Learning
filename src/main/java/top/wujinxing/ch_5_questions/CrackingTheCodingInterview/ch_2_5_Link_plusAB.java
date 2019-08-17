package top.wujinxing.ch_5_questions.CrackingTheCodingInterview;

/**
 * @author wujinxing
 * date 2019 2019/8/17 14:55
 * description 链式A+B
 *
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，
 * 也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 *
 * 测试样例：
 * {1,2,3},{3,2,1}
 * 返回：{4,4,4}
 */
public class ch_2_5_Link_plusAB {

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        p.next = new ListNode(2);
        p.next.next = new ListNode(3);
        //System.out.println(funcA(p));
        System.out.println(funcB(123));
    }

    //添加两个函数
    public static ListNode plusAB(ListNode a, ListNode b) {
        int intA = funcA(a);
        int intB = funcA(b);
        int sum = intA+intB;
        return funcB(sum);
    }
    private static int funcA(ListNode a){
        int count = 1;
        int sum = 0;
        while (a!=null){
            sum += a.val*count;
            a = a.next;
            count *= 10;
        }
        return sum;
    }
    private static ListNode funcB(int num){
        String s = String.valueOf(num);
        int len = s.length();
        ListNode p = new ListNode(0);//p是移动节点
        ListNode p2 = p;//p2为存储节点
        for(int i=len-1; i>=0; i--){
            ListNode p1 = new ListNode(s.charAt(i)-48);
            System.out.println(p1.val);
            p.next = p1;
            p = p.next;
        }
        return p2.next; //去掉值为0的头结点
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

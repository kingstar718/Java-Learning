package top.wujinxing.cracking_the_coding_interview;

import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/8/18 16:41
 * description 用两个栈实现队列
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

 * <分析>：
 *
 * 入队：将元素进栈A
 * 出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；
 *如果不为空，栈B直接出栈。
 *
 * 用两个队列实现一个栈的功能?要求给出算法和思路!
 * <分析>：
 * 入栈：将元素进队列A
 * 出栈：判断队列A中元素的个数是否为1，如果等于1，则出队列，否则将队列A中的元素
 * 以此出队列并放入队列B，直到队列A中的元素留下一个，然后队列A出队列，再把队列B中的元素出队列以此放入队列A中。
 */
public class ch_3_5_Stack_twoStack {

    public static void main(String[] args) {
        stackForQueue sq = new stackForQueue();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
    }


    static class stackForQueue{

        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack1.isEmpty() && stack2.isEmpty()){
                throw new RuntimeException("Queue is empty!");
            }
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}

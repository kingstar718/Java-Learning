package top.wujinxing.ch_5_questions.SwordOffer;

import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/9/4 12:55
 * description 用两个栈实现一个队列
 *
 * 用两个栈来实现一个队列，完成队列的`Push`和`Pop`操作。 队列中的元素为`int`类型。
 */
public class ch_05_queueForStack {

    public static void main(String[] args) {
        Q queue = new Q();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    /**
     * 1、push的时候直接push到stack1中
     * 2、stack2为空时，一次性将stack1的全部push到stack2中
     * 3、pop时，取得就是stack2的栈顶
     */
    static class Q{
        Stack<Integer> stack1= new Stack<>();
        Stack<Integer> stack2= new Stack<>();

        public void push(int node){
            stack1.push(node);
        }
        public int pop(){
            if (stack1.isEmpty()&&stack2.isEmpty())
                throw new RuntimeException("isEmpty");
            //stack2不为空的话，先不要将stack1的内容放进去
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}

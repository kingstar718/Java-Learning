package top.wujinxing.ch_5_questions.SwordOffer;

import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/9/4 21:41
 * description 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的`min`函数（时间复杂度应为O（1））。
 */
public class ch_20_minStack {

    /**
     * 压入规则 1.先将node压入stackData中
     * 2.判断stackMin是否为空，若为空，同时将node压入stackMin中
     * 3.如果node <= stackMin.peek() 则也同时将node压入stackMin中;
     *    否则,即node > stackMin.peek()，则重复压入stackMin.peek()到stackMin中（即保留上一个最小值）
     *  为什么这么处理，因为这样之后，pop()过程变得简单了，直接弹出即可
    */

    Stack<Integer> stackData = new Stack<>(); //数据栈
    Stack<Integer> stackMin = new Stack<>(); //辅助栈

    public void push(int node){
        stackData.push(node);
        if (stackMin.isEmpty()){
            stackMin.push(node);
        }else {
            if (node <= stackMin.peek())
                stackMin.push(node);
            else  //压入是唯一的改动
                stackMin.push(stackMin.peek());
        }
    }

    public void pop(){
        stackData.pop();  //直接弹出即可
        stackMin.pop();
    }

    public int top(){
        if (stackData.isEmpty())
            throw new RuntimeException("stack is Empty!");
        return stackData.peek();
    }

    public int min(){
        if (stackMin.isEmpty())
            throw new RuntimeException("stack is Empty!");
        return stackMin.peek();
    }
}

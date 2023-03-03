package top.wujinxing.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujinxing
 * @date 2023/3/3
 */
public class ChSwordOffer09TwoStackToQueue {

    Deque<Integer> headStack;
    Deque<Integer> tailStack;

    public ChSwordOffer09TwoStackToQueue() {
        headStack = new LinkedList<>();
        tailStack = new LinkedList<>();
    }

    /** 入队 */
    public void appendTail(int value) {
        // 入队，在tailStack压入值
        tailStack.push(value);
    }

    /** 出队 */
    public int deleteHead() {
        if (headStack.isEmpty()) {
            while (!tailStack.isEmpty()) {
                headStack.push(tailStack.pop());
            }
        }
        if (headStack.isEmpty()) {
            return -1;
        }
        return headStack.pop();
    }

}

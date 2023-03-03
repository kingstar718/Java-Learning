package top.wujinxing.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujinxing
 * @date 2023/3/3
 *
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 */
public class Ch225ImplementStackUsingQueues {

    public static class TwoQueue {

        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public TwoQueue() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue2.offer(x);
            // 先用2接入，然后将1的元素追加到2后，交换1 2
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    public static class Single {

        Queue<Integer> queue;

        public Single() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            // 将之前的元素追加到新添加元素的后边
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
        return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

}

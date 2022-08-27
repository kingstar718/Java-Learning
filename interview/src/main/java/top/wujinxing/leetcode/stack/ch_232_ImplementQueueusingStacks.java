package top.wujinxing.leetcode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/12/31 19:10
 * description 用栈实现队列
 * <p>
 * 使用栈实现队列的下列操作：
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 */
public class ch_232_ImplementQueueusingStacks {

    class MyQueue {

        private int front;

        private Stack<Integer> s1;
        private Stack<Integer> s2;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (s1.isEmpty()) {
                front = x;
            }
            s1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            }
            return s2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!s2.isEmpty()) {
                return s2.peek();
            }
            return front;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    class MyQueue2 {

        private int front;

        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public MyQueue2() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /**
         * 先将s1中的所有元素都移到s2，接着把新元素压入s2，最后把s2中的所有元素弹出，压入s1
         */
        public void push(int x) {
            if (s1.isEmpty())
                front = x;
            while (!s1.isEmpty())
                s2.push(s1.pop());
            s2.push(x);
            while (!s2.isEmpty())
                s1.push(s2.pop());
        }

        /**
         * 直接从 s1 弹出就可以了，因为 s1 的栈顶元素就是队列的队首元素。
         * 同时我们把弹出之后 s1 的栈顶元素赋值给代表队首元素的 front 变量。
         */
        public int pop() {
            if (!s1.isEmpty())
                front = s1.peek();
            return s1.pop();
        }

        public boolean empty() {
            return s1.empty();
        }

        /**
         * 在我们的算法中，用了 front 变量来存储队首元素，在每次 入队 操作或者 出队 操作之后这个变量都会随之更新。
         */
        public int peek() {
            return front;
        }
    }


    @Test
    public void test() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        while (!queue.empty()) {
            System.out.print(queue.pop() + " ");
        }

        MyQueue2 queue2 = new MyQueue2();
        queue2.push(1);
        queue2.push(2);
        queue2.push(3);
        queue2.push(4);
        while (!queue2.empty()) {
            System.out.print(queue2.pop() + " ");
        }
    }
}

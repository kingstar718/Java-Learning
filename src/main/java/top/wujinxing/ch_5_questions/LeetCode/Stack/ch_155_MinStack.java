package top.wujinxing.ch_5_questions.LeetCode.Stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/12/31 16:58
 * description 最小栈
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class ch_155_MinStack {

    class MinStack {

        private Stack<Integer> data;
        private Stack<Integer> helper;

        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        // 思路1，数据栈和辅助栈在任何时间都同步
        public void push(int x) {
            data.add(x);
            // 为空或者当前元素小于栈顶元素，则加入，否则继续加入栈顶元素
            if (helper.isEmpty() || helper.peek() >= x) {
                helper.add(x);
            } else {
                helper.add(helper.peek());
            }
        }

        public void pop() {
            // 两个栈都得pop
            if (!data.isEmpty()) {
                helper.pop();
                data.pop();
            }
        }

        public int top() {
            if (!data.isEmpty()) {
                return data.peek();
            } else {
                throw new RuntimeException("栈中元素为空，此操作非法");
            }
        }

        public int getMin() {
            if (!helper.isEmpty()) {
                return helper.peek();
            } else {
                throw new RuntimeException("栈中元素为空，此操作非法");
            }
        }
    }

    class MinStack2 {

        private Stack<Integer> data;
        private Stack<Integer> helper;

        public MinStack2() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        // 思路 2：辅助栈和数据栈不同步
        // 关键 1：辅助栈的元素空的时候，必须放入新进来的数
        // 关键 2：新来的数小于或者等于辅助栈栈顶元素的时候，才放入（特别注意这里等于要考虑进去）
        // 关键 3：出栈的时候，辅助栈的栈顶元素等于数据栈的栈顶元素，才出栈，即"出栈保持同步"就可以了

        public void push(int x) {
            data.add(x);
            // 为空或者当前元素小于栈顶元素，则加入
            if (helper.isEmpty() || helper.peek() >= x) {
                helper.add(x);
            }
        }

        public void pop() {
            // 两个栈都得pop
            if (!data.isEmpty()) {
                int top = data.pop();
                if (top == helper.peek()) {
                    helper.pop();
                }
            }
        }

        public int top() {
            if (!data.isEmpty()) {
                return data.peek();
            } else {
                throw new RuntimeException("栈中元素为空，此操作非法");
            }
        }

        public int getMin() {
            if (!helper.isEmpty()) {
                return helper.peek();
            } else {
                throw new RuntimeException("栈中元素为空，此操作非法");
            }
        }
    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(1);
        minStack.push(3);
        minStack.push(5);
        System.out.println(minStack.getMin());
    }


}

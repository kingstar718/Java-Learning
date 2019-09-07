package top.wujinxing.ch_5_questions.SwordOffer;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/9/7 21:00
 * description 栈的压入、弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class ch_21_IsPopOrder {

    //1.遍历pushA，使用一个索引popIndex下标记录popA走到的位置，如果pushA[i] = popA[popIndex],popIndex++
    //2.不相等，就入栈pushA[i]
    //3.最后全部弹出栈,每弹一个,就看stack.pop()==popA[popIndex],如果不等就返回false, 否则返回true
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == popA[popIndex]) {
                popIndex++;
            } else {
                stack.push(pushA[i]);
            }
        }
        while (stack.isEmpty()) {
            if (stack.pop() != popA[popIndex]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(a, b));
    }
}

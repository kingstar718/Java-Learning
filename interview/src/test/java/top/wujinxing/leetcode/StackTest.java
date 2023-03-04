package top.wujinxing.leetcode;

import org.junit.Assert;
import org.junit.Test;
import top.wujinxing.leetcode.stack.Ch1047RemoveAllAdjacentDuplicatesInString;
import top.wujinxing.leetcode.stack.Ch150EvaluateReversePolishNotation;
import top.wujinxing.leetcode.stack.Ch20ValidParentheses;
import top.wujinxing.leetcode.stack.Ch225ImplementStackUsingQueues;

/**
 * @author wujinxing
 * @date 2023/3/3
 */
public class StackTest {

    @Test
    public void singleToStack() {
        Ch225ImplementStackUsingQueues.Single single = new Ch225ImplementStackUsingQueues.Single();
        single.push(1);
        single.push(2);
        Assert.assertEquals(2, single.top());
        Assert.assertEquals(2, single.pop());
        Assert.assertFalse(single.empty());
        Assert.assertEquals(1, single.pop());
        Assert.assertTrue(single.empty());
    }

    @Test
    public void twoQueueStack() {
        Ch225ImplementStackUsingQueues.TwoQueue twoQueue = new Ch225ImplementStackUsingQueues.TwoQueue();
        twoQueue.push(1);
        twoQueue.push(2);
        Assert.assertEquals(2, twoQueue.top());
        Assert.assertEquals(2, twoQueue.pop());
        Assert.assertFalse(twoQueue.empty());
        Assert.assertEquals(1, twoQueue.pop());
        Assert.assertTrue(twoQueue.empty());
    }

    @Test
    public void validParentheses() {
        String s1 = "((({[]})))[]{[]}";
        String s2 = "((({[]})))[]{[[]}";
        Assert.assertTrue(new Ch20ValidParentheses().isValid(s1));
        Assert.assertFalse(new Ch20ValidParentheses().isValid(s2));
        Assert.assertTrue(new Ch20ValidParentheses().isValid2(s1));
        Assert.assertFalse(new Ch20ValidParentheses().isValid2(s2));
    }

    @Test
    public void removeDuplicates() {
        Assert.assertEquals("ca", Ch1047RemoveAllAdjacentDuplicatesInString.removeDuplicates("abbaca"));
    }

    @Test
    public void evalRPN() {
        Assert.assertEquals(9, Ch150EvaluateReversePolishNotation
                .evalRPN(new String[]{"2", "1", "+", "3", "*" }));
        Assert.assertEquals(6, Ch150EvaluateReversePolishNotation
                .evalRPN(new String[]{"4", "13", "5", "/", "+" }));
        Assert.assertEquals(22, Ch150EvaluateReversePolishNotation
                .evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));
    }

}

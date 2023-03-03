package top.wujinxing.leetcode;

import org.junit.Assert;
import org.junit.Test;
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

}

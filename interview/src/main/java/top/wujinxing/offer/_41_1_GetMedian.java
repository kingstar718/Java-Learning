package top.wujinxing.offer;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author wujinxing
 * date 2019 2019/7/2 14:40
 * description 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class _41_1_GetMedian {

    @Test
    public void test(){
        Integer[] nums = {1,2,3,4,5,6,7,8,9};
        for (Integer n: nums
             ) {
            Insert(n);
        }
        System.out.println(GetMedian());
    }

    //大顶堆，存储左半边元素
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->o2-o1);
    //小顶堆，存储右半边元素，并且右半边元素都大于左半边
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    //当前数据流读入的元素个数
    private int N = 0;

    public void Insert(Integer num) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N%2==0){
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
            left.add(num);
            right.add(left.poll());
        }else {
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N%2==0){
            return (left.peek()+right.peek())/2.0;
        }else{
            return (double)right.peek();
        }
    }

}

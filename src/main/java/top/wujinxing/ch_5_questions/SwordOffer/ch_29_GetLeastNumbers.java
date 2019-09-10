package top.wujinxing.ch_5_questions.SwordOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author wujinxing
 * date 2019 2019/9/10 17:56
 * description 最小的K个数
 * <p>
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class ch_29_GetLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length)
            return res;

        //维护了一个最大堆（即堆顶最大）
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (o1, o2) -> {
                    return o1 < o2 ? 1 : (o1 == 02 ? 0 : -1);
                }
        );
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.add(input[i]); //不足K个数，直接添加
            } else if (input[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(input[i]);
            }
        }
        for (Integer item : maxHeap) {
            res.add(item);
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(arr, 4));
    }
}

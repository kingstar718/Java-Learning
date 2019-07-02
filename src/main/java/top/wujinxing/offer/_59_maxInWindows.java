package top.wujinxing.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author wujinxing
 * date 2019 2019/7/2 15:21
 * description华东窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class _59_maxInWindows {

    @Test
    public void test(){
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(num,3).toString());
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size){
        ArrayList<Integer> ret = new ArrayList<>();
        if (size>num.length || size<1) return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->o2-o1);//大顶堆
        for (int i=0; i<size; i++){
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        for (int i=0,j=i+size; j<num.length; i++,j++){/* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}

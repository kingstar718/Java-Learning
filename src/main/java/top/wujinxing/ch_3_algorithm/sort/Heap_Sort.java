package top.wujinxing.ch_3_algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wujinxing
 * @date: 2019/1/16 16:05
 * @description:堆排序
 *堆的定义：n个元素的序列{k1,k2,...kn}当且仅当满足ki<=k2i&ki<=k2i+1或者ki>=k2i&ki>=k2i+1(i=1,2...|n/2|)
 * 那么此序列的对应的二维数组看成一个完全二叉树，那么堆得含义就是：完全二叉树中的任何一个非叶子节点的值均不大于（不小于）其左右孩子节点的值
 *
 * 以最大堆为列，堆排序的过程就是将待排序的序列构造成一个堆，选出堆中最大的移走，再把剩余的元素调整成堆，找出最大的再移走，重复直至有序
 *
 * 1.先将初始序列K[1..n]建成一个最大堆，那么此时K1最大，，此堆为初始的无序区
 * 2.再将关键字最大的记录K1(即堆顶，第一个元素)和无序区的最后一个记录Kn交换，由此得到新的无序区K[1...Kn-1]和有序区K[n]且满足K[1...Kn-1].keys<=K[n].keys
 * 3.交换K1和Kn后，堆顶可能违反最大堆得性质，因此需要将K[1...n-1]调整为堆，然后重复步骤2，直到无序区只有一个元素时停止
 *
 * 操作：
 * 最大堆调整（Max_Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
 * 创建最大堆（Build_Max_Heap）：将堆所有数据重新排序
 * 堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
 *
 * 对于堆节点的访问：
 * 父节点i的左子节点在位置：(2*i+1);
 * 父节点i的右子节点在位置：(2*i+2);
 * 子节点i的父节点在位置：floor((i-1)/2);
 */
public class Heap_Sort {

    public static void heapSort(int[] arr){
        for (int i = arr.length; i > 0; i--){
            max_heapify(arr,i);
            //堆顶元素与Kn交换
            int temp = arr[0];
            arr[0] = arr[i-1];
            arr[i-1] = temp;
        }
    }

    private static void max_heapify(int[] arr, int limit){
        if(arr.length <= 0 || arr.length < limit) return;
        int parentIndex = limit/2;
        for (; parentIndex >= 0; parentIndex--){
            if (parentIndex*2 >= limit){
                continue;
            }
            int left = parentIndex * 2;     //左子节点位置
            int right = (left+1) >= limit ? left : (left+1);    //右子节点位置，没有就默认为左子节点位置

            int maxChildId = arr[left] >= arr[right] ? left :right;
            if (arr[maxChildId] > arr[parentIndex]){    //交换父节点与左右节点中的最大值
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[maxChildId];
                arr[maxChildId] = temp;
            }
        }
        System.out.println("Max_Heapify: " + Arrays.toString(arr));
    }

    @Test
    public void test(){
        int[] a = {4,5,1,2,44,23,21,2113,56,27,99,8,13,33,12,1212,14,44,65,23,112};
        heapSort(a);
    }
}

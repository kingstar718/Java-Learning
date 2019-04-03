package top.wujinxing.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: wujinxing
 * @date: 2019/3/11 11:25
 * @description:
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k){
        ArrayList a = new ArrayList();
        Arrays.sort(input);
        if (input.length < k) return a;
        for (int i = 0; i < k; i++){
            a.add(input[i]);
        }
        return a;
    }

    @Test
    public void test(){
        int[] a = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(a, 4));
    }
}

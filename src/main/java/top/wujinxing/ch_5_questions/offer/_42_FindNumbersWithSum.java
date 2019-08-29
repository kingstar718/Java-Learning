package top.wujinxing.ch_5_questions.offer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: wujinxing
 * @date: 2019/4/4 09:11
 * @description: 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class _42_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSumTest(int[] array, int sum){
        ArrayList<Integer> list = new ArrayList<>();
        if (array==null || array.length<2){
            return list;
        }
        int i = 0, j = array.length-1;
        while (i<j){
            if (array[i]+array[j]==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if(array[i]+array[j]>sum){
                j--;
            }else {
                i++;
            }
        }
        return list;
    }

    @Test
    public void test(){
        int[] a1 = {1,2,3,4,5,6,7,9,11,20};
        int[] a2 = {-1,2,-3,4,5,6,7,9,11,20};
        int s1 = 16;
        int s2 = -1;
        System.out.println(FindNumbersWithSumTest(a1, s1));
        System.out.println(FindNumbersWithSumTest(a2, s2));
    }
}

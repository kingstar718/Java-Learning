package top.wujinxing.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/3/11 11:50
 * @description:
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,
 * 问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        //new数组保存所有子序列之和
        //返回最大的
        //int[] m = new int[array.length];
        List<Integer> m = new ArrayList();  //必须使用ArrayList保存所有值
        for(int i = 0; i < array.length; i++){
            int sum = 0;
            for(int j = i; j <array.length; j++){
                sum += array[j];
                m.add(sum);
            }
            //m[i] = sum;
        }
        //int result = 0;
        //for(int i = 0; i < m.length; i++){
        //if(result < m[i]){
        //result = m[i];
        //}
        //}
        if(m.size() <= 0) return 0;
        Collections.sort(m);
        return m.get(m.size()-1);
    }

    public int FindGreatestSumOfSubArray2(int[] array){
        if (array.length==0 || array==null) return 0;

        int sum = 0;
        int greatSum = 0x80000000;
        for (int i = 0; i < array.length; i++){
            if (sum <= 0){
                sum += array[i]; //记录当前最大值
            }else {
                sum += array[i]; ////当array[i]为正数时，加上之前的最大值并更新最大值。
            }
            if (sum > greatSum) greatSum = sum;
        }
        return greatSum;
    }

    @Test
    public void test(){
        int[] a = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(a));
        System.out.println(FindGreatestSumOfSubArray2(a));
    }
}

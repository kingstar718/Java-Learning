package top.wujinxing.ch_5_questions.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/3/18 21:19
 * @description:
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请
 * 写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {

    @Test
    public void test(){
        int[] array = {1,1,2,2,3,4,4,5,5,6};
        int[] array1 = {1,1,1,1,4,6};
        int[] a = new int[1];
        int[] b = new int[1];
        FindNumsAppearOnce1(array1,a,b);
        System.out.println(a[0]+" "+b[0]);
    }
    public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<array.length; i++){
            int count = 0;
            for(int j=0;j<array.length;j++){
                if(array[i]==array[j]){
                    count++;
                }
            }
            if(count==1){
                list.add(array[i]);
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }
}

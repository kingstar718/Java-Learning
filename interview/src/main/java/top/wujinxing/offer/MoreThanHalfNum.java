package top.wujinxing.offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: wujinxing
 * @date: 2019/3/11 10:59
 * @description:
 * 输出数组中重复次数最多的元素，如果出现次数低于数组长度的一半，则返回0
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        //一个数组
        //计算每个元素重复度，加进数组
        //比较数据元素哪个大
        //最大的索引拿出来根据原数组找出该元素
        int n = array.length;
        int[] l = new int[n];
        for(int i = 0; i < n; i++){
            int count = 1;
            for(int j = 0; j < n; j++){
                if((array[i] == array[j])&&i!=j){
                    count++;
                }
            }
            l[i] = count;
        }
        int s = 0;
        for(int i = 1 ; i < n-1; i++){
            if(l[i] > l[s]){
                s = i;
            }
        }
        int half = n/2;
        if(l[s] <= half){
            return 0;
        }else{
            return array[s];
        }
    }

    public int MoreThanHalfNum_Solution2(int[] array){
        int len = array.length;
        if (len<1) return 0;

        int count = 0;
        Arrays.sort(array);
        int num = array[len/2];
        for (int i = 0; i < len; i++){
            if (num == array[i]) count++;
        }
        if (count <= (len/2)) num = 0;
        return num;

    }

    @Test
    public void test(){
        int[] a = {1,2,3,2,2,2,5,4,2};
        int[] b = {1,2,3,2,4,2,5,2,3};
        System.out.println(MoreThanHalfNum_Solution(a));
        System.out.println(MoreThanHalfNum_Solution(b));
        System.out.println(MoreThanHalfNum_Solution2(a));
        System.out.println(MoreThanHalfNum_Solution2(b));

    }
}

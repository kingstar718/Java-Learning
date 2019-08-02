package top.wujinxing.ch_5_questions.offer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: wujinxing
 * @date: 2019/3/18 21:51
 * @description:
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    @Test
    public void test(){
        int sum = 100;
        System.out.println(FindContinuousSequenceTest(sum));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequenceTest(int sum){
        //存放结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow =1, phigh = 2;
        while (phigh>plow){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh+plow)*(phigh-plow+1)/2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if (cur==sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
            }else if(cur<sum){
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
                phigh++;
            }else {
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }
}

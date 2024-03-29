package top.wujinxing.sword_offer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author wujinxing
 * date 2019 2019/9/12 9:44
 * description 和为S的连续正数序列
 * <p>
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class ch_41_FindContinuousSequence {

    //滑动窗口
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int pLow = 1, pHigh = 2;
        while (pHigh > pLow) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (pHigh + pLow) * (pHigh - pLow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = pLow; i <= pHigh; i++) {
                    list.add(i);
                }
                result.add(list);
                pLow++;
            } else if (cur < sum) {
                pHigh++; //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else {
                pLow++;//如果当前窗口内的值之和大于sum，那么左边窗口右移一下
            }
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(FindContinuousSequence(100));
    }
}

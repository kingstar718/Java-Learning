package top.wujinxing.ch_5_questions.LeetCode.Array;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/1/16 09:36
 * @description: 何时买进何时卖出才是最赚，返回最大收益值
 */
public class max_Profit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, s = 0;
        //if(prices.length() <= 0) return;
        for(int i = 0; i < prices.length-1; i++){
            for(int j=i+1; j < prices.length; ++j){
                s = prices[j] - prices[i];
                if(maxProfit <= s && s >= 0){
                    maxProfit = s;
                }
            }
        }
        return maxProfit;
    }
    @Test
    public void test(){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}

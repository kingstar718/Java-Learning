package top.wujinxing.ch_5_questions.offer;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/3/11 13:45
 * @description:  在1-N内多少个包含1的数
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while(n>0){
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for(int i = 0; i < chars.length; i++){
                if(chars[i] == '1'){
                    count++;
                }
            }
            n--;
        }
        return count;
    }

    @Test
    public void test(){
        int n = 1300;
        System.out.println(NumberOf1Between1AndN_Solution(n));
    }
}

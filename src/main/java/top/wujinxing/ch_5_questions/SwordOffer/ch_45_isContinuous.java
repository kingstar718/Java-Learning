package top.wujinxing.ch_5_questions.SwordOffer;


import org.junit.Test;

import java.util.Arrays;

/**
 * 扑克牌顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2~10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
 * 如果牌能组成顺子就输出true，否则就输出false。**为了方便起见,你可以认为大小王是0。
 */

public class ch_45_isContinuous {

    /**
     * 最大的牌到最小的牌的距离要小于5
     * 也是不能有重复的牌 除0外
     *
     * @param numbers 数组
     * @return boolean
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5)
            return false;
        Arrays.sort(numbers);
        int interval = 0, zero = 0;
        for (int i = 0; i < 4; i++) {
            if (numbers[i] == 0) { //写在循环前面, 且numbers[4]不需要判断了
                zero++;
                continue;// 记得不要判断下面的对子了，因为number[i+1]有可能也是0
            }
            if (numbers[i] == numbers[i + 1])
                return false;
            interval += numbers[i + 1] - numbers[i] - 1;
        }
        return zero >= interval;
    }

    @Test
    public void test(){
        int[] arr = {2,3,4,5,6};
        int[] arr2 = {2,7,4,5,6};
        System.out.println(isContinuous(arr));
        System.out.println(isContinuous(arr2));
    }
}

package top.wujinxing.ch_5_questions.offer.bilibili;

/**
 * @author wujinxing
 * date 2019 2019/8/21 19:38
 * description 简单dp问题
 *
 * 有一个升序数组，不能拿相邻的数，问怎么拿才能使拿到的数之和最大
 */
public class simpleDP {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};

        //dp[i]表示前i个数中这么取最大的是多少
        int[] dp = new int[array.length];

        dp[0] = array[0];
        dp[1] = array[1];

        for (int i=2; i<array.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+array[i]);
            System.out.println("dp的第" + i + " 个下标的值为" + dp[i]);
        }
        System.out.println(dp[array.length-1]);
    }
}

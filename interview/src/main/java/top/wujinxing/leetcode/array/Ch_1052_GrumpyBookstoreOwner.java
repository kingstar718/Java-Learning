package top.wujinxing.leetcode.array;


/**
 * <a href="https://leetcode.cn/problems/grumpy-bookstore-owner/">GrumpyBookstoreOwner</a>
 * <p>
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意。
 */
public class Ch_1052_GrumpyBookstoreOwner {

    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int x = 3;
        System.out.println(maxSatisfied(customers, grumpy, x));
    }

    /**
     * 将不生气的部分作为固定窗口，固定窗口将顾客分成了三部分，求最后三部分的最大和
     */
    private static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // 窗口值总和
        int winSum = 0;
        int leftSum = 0;
        int rightSum = 0;
        int len = customers.length;
        // 窗口位于起点
        for (int i = 0; i < minutes; i++) {
            winSum += customers[i];
        }
        // 窗口位于起点时右区间的值
        for (int i = minutes; i < len; i++) {
            if (grumpy[i] == 0) {
                rightSum += customers[i];
            }
        }
        int left = 1;
        int right = minutes;
        int maxSum = winSum + leftSum + rightSum;
        while (right < len) {
            // 重新计算左区间的值
            if (grumpy[left - 1] == 0) {
                leftSum += customers[left - 1];
            }
            // 重新计算右区间的值
            if (grumpy[right] == 0) {
                rightSum -= customers[right];
            }
            // 窗口值
            winSum = winSum - customers[left - 1] + customers[right];
            // 最大总和
            maxSum = Math.max(maxSum, leftSum + winSum + rightSum);
            // 移动固定窗口
            left++;
            right++;
        }
        return maxSum;
    }

}

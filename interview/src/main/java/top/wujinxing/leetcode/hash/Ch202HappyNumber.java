package top.wujinxing.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujinxing
 * @date 2023-03-02
 * </p>
 * <a href="https://leetcode.cn/problems/happy-number/">202. Happy Number</a>
 */
public class Ch202HappyNumber {

    /**
     * 使用set存储已经出现过的平方和，如果出现过，则就是无线循环了
     */
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = sum(n);
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
    }

    private static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }
        return sum;
    }

}

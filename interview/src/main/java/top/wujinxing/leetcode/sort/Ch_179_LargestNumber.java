package top.wujinxing.leetcode.sort;

import java.util.Arrays;

/**
 * @author wujinxing
 * @date 2023/3/23
 *
 * <a href="https://leetcode.cn/problems/largest-number/">179. 最大数</a>
 */
public class Ch_179_LargestNumber {

    public static String largestNumber(int[] numbs) {
        int n = numbs.length;
        Integer[] numbsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numbsArr[i] = numbs[i];
        }
        Arrays.sort(numbsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });
        if (numbsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numbsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

}

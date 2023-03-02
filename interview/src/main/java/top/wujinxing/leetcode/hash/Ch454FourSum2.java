package top.wujinxing.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujinxing
 * @date 2023-03-02
 */
public class Ch454FourSum2 {

    /**
     * 首先定义 一个HashMap，key放A和B两数之和，value 放A和B两数之和出现的次数。
     * 遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
     * 定义int变量count，用来统计a+b+c+d = 0 出现的次数。
     * 在遍历大C和大D数组，找到如果 0-(C+D) 在map中出现过的话，就用res把map中key出现的次数
     * 最后返回统计值 count
     */
    public static int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int sumAb = a[i] + b[j];
                map.put(sumAb, map.getOrDefault(sumAb, 0) + 1);
            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                int sumCd = -(c[i] + d[j]);
                if (map.containsKey(sumCd)) {
                    res += map.get(sumCd);
                }
            }
        }
        return res;
    }

}

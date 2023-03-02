package top.wujinxing.leetcode.hash;

import java.util.*;

/**
 * @author wujinxing
 * @date 2023-03-02
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Ch349IntersectionOfTwoArrays {

    public static int[] intersection(int[] numbs1, int[] numbs2) {
        if (Objects.isNull(numbs1) || Objects.isNull(numbs2) ||
                numbs1.length == 0 || numbs2.length == 0) {
            return new int[]{};
        }
        Set<Integer> set1 = new HashSet<>();
        for (int i : numbs1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : numbs2) {
            set2.add(i);
        }
        List<Integer> res = new ArrayList<>();
        for (Integer i : set1) {
            if (set2.contains(i)) {
                res.add(i);
            }
        }
        int[] resInt = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resInt[i] = res.get(i);
        }
        return resInt;
    }
}

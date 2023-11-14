package top.wujinxing.datastructure.hash;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/9/5 14:28
 * description 两个数组求交集
 * 有序 可不用hash
 * 无序 需要哈希
 */
@Slf4j
public class ArrayIntersection {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5, 6};
        int[] a2 = {0, 1, 3, 4, 8, 10};
        List<Integer> result = arrayIntersection(a1, a2);
        log.info("a1:  {}", Arrays.toString(a1));
        log.info("a2:  {}", Arrays.toString(a2));
        log.info("交集: {}", result);
    }

    public static List<Integer> arrayIntersection(int[] a1, int[] a2) {
        int[] arr = new int[Math.max(a1[a1.length - 1], a2[a2.length - 1]) + 1];
        for (Integer n : a1) {
            arr[n.hashCode()]++;
        }
        List<Integer> list = new ArrayList<>();
        for (Integer n : a2) {
            if (arr[n.hashCode()] != 0) {
                list.add(n);
            }
        }
        return list;
    }
}

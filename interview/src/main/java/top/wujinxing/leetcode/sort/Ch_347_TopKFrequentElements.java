package top.wujinxing.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujinxing
 * @date 2023/3/23
 * <p>
 * <a href="https://leetcode.cn/problems/top-k-frequent-elements/">347. 前 K 个高频元素</a>
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class Ch_347_TopKFrequentElements {

    public static int[] topKFrequent(int[] numbs, int k) {
        // 使用hash map村村元素出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int numb : numbs) {
            map.put(numb, map.getOrDefault(numb, 0) + 1);
        }
        // 桶
        List<Integer>[] buckets = new ArrayList[numbs.length + 1];
        // 往桶里添加元素出现次数
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            // 根据出现频率决定元素入哪个桶
            int count = m.getValue();
            // 初始化桶
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            // 将元素存在桶中
            buckets[count].add(m.getKey());
        }
        // 结果列表
        List<Integer> result = new ArrayList<>();
        // 取倒数k个非空桶中的元素
        for (int i = buckets.length - 1; k > 0; i--) {
            if (buckets[i] != null) {
                // 取出通中的元素
                for (Integer num : buckets[i]) {
                    result.add(num);
                    k--;
                }
            }
        }
        // 将列表中的元素赋给数组
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}

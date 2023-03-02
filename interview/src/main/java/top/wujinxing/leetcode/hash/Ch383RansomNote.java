package top.wujinxing.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujinxing
 * @date 2023-03-02
 * <a href="https://leetcode.cn/problems/ransom-note/">383. Ransom Note</a>
 */
public class Ch383RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char m = magazine.charAt(i);
            hash.put(m, hash.getOrDefault(m, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!hash.containsKey(c)) {
                return false;
            }
            if (hash.get(c) == 0) {
                return false;
            }
            hash.put(c, hash.get(c) - 1);
        }
        return true;
    }

}

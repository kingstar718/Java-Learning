package top.wujinxing.leetcode.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinxing
 * @date 2023-03-01
 */
public class Ch1002FindCommonCharacters {

    /**
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
     * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
     */
    public static List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        int[] hash = new int[26];
        // 用第一个字符串给hash初始化
        for (int i = 0; i < words[0].length(); i++) {
            hash[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] hashOthers = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                hashOthers[words[i].charAt(j) - 'a']++;
            }
            // 更新hash内的值，保证hash里统计26个字符在所有字符串里出现的最小次数
            for (int j = 0; j < 26; j++) {
                hash[j] = Math.min(hash[j], hashOthers[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) {
                char c = (char) (i + 'a');
                res.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return res;
    }
}

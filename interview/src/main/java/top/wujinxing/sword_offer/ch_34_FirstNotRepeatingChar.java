package top.wujinxing.sword_offer;

import java.util.HashMap;

/**
 * @author wujinxing
 * date 2019 2019/9/10 23:52
 * description 第一个只出现一次的字符
 * <p>
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class ch_34_FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        //因为字母`ascii`在`65 ~ 122`，所以开一个`58`的数组就可以了。
        int[] counts = new int[58];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'A']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (counts[str.charAt(i) - 'A'] == 1)
                return i;
        }
        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        if (str == null || str.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}

package top.wujinxing.ch_3_algorithm.datastructure.string;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019/9/22 1:18
 * description 判断两个字符串是否互为变形词
 * 描述：出现的字符种类一样且每种字符出现的次数也一样
 * str1="123", str2="231" true
 * str1="123", str2="2331" false
 */
public class ch_2_isDeformation {

    private boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str1.toCharArray();

        int[] map = new int[256];

        for (char c : chars1) {
            map[c]++;
        }
        for (char c : chars2) {
            if (map[c]-- == 0)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        String str1 = "123";
        String str2 = "231";
        String str3 = "123";
        String str4 = "2321";
        System.out.println(isDeformation(str1, str2));
        System.out.println(isDeformation(str3, str4));
    }
}

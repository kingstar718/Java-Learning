package top.wujinxing.offer;

import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * @author: wujinxing
 * @date: 2019/3/12 11:18
 * @description:求第一个出现的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingCharTest(String str){
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++){
            if (map.containsKey(str.charAt(i))){//判断Map集合对象中是否包含指定的键名
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            }else {
                map.put(str.charAt(i), 1);
            }
        }
        int pos = -1;
        int i = 0;
        for (; i < str.length(); i++){
            char c = str.charAt(i);
            if (map.get(c) == 1){
                return i;
            }
        }
        return pos;
    }

    @Test
    public void test(){
        String s = "absasbascswe";
        System.out.println(FirstNotRepeatingCharTest(s));
    }
}

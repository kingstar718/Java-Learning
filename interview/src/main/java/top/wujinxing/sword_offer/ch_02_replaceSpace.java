package top.wujinxing.sword_offer;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/8/29 13:21
 * description 替换字符串中的空格
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成`“%20”`。
 * 例如，当字符串为`We Are Happy.`则经过替换之后的字符串为`We%20Are%20Happy.`。
 * <p>
 * 思路：
 * 这个题目如果只是简单的插入的话，插入之后导致后面的元素的移动导致，需要O(n^2)的复杂度；
 * 这个的解决方法使用两个指针，可以达到`O(n)`复杂度；
 * 首先计算出空格的个数，这样求的新的字符串的长度；
 * 然后使用两个指针,新的指针`second`指向新的字符串的末尾，老指针`first`指向原来字符串的末尾，每次检查字符串的末尾如果是空格的话，就添加`%20`进去，否则把原来的字符串复制到后面；
 */
public class ch_02_replaceSpace {

    private String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                spaceNum++;
        }
        int newLen = str.length() + 2 * spaceNum; //新字符串长度，即原空格+2个 = %20
        int oldPos = str.length() - 1, newPos = newLen - 1;
        str.setLength(newLen);

        for (; oldPos >= 0; oldPos--) {
            if (str.charAt(oldPos) == ' ') {
                str.setCharAt(newPos--, '0');
                str.setCharAt(newPos--, '2');
                str.setCharAt(newPos--, '%');
            } else {
                str.setCharAt(newPos--, str.charAt(oldPos));
            }
        }
        return str.toString();
    }

    @Test
    public void test(){
        String s = "We Are Happy";
        StringBuffer str = new StringBuffer(s);
        System.out.println(replaceSpace(str));
    }
}

package top.wujinxing.leetcode.string;

import org.junit.Test;


/**
 * @author: wujinxing
 * @date: 2019/3/2 20:05
 * @description:
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * 判断字符串是否为回文
 */
public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        //System.out.println(actual);
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    @Test
    public void test(){
        String a = "A man, a plan, a canal: Panama";
        String b = "race a car";
        System.out.println(isPalindrome(a));
        System.out.println(isPalindrome(b));
    }
}

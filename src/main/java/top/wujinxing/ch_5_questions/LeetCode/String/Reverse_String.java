package top.wujinxing.ch_5_questions.LeetCode.String;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/2/25 21:58
 * @description: 344
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class Reverse_String {
    public void reverseString(char[] s) {
        for(int i = 0; i < s.length/2; i++){
            char temp = s[i];
            int j = s.length - i - 1;
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public String reverseString2(char[] word) {
        //char[] word = s.toCharArray();
        int i = 0;
        int j = word.length - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    public static void printTest(char[] A){
        for (char a :
             A) {
            System.out.print(a);
        }
        System.out.println();
    }
    @Test
    public void test(){
        char[] a = {'h','e','l','l','o'};
        char[] b = {'H','a','n','n','a','h'};
        reverseString(a);
        reverseString2(b);
        printTest(a);
        printTest(b);
    }
}

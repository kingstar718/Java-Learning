package top.wujinxing.cracking_the_coding_interview;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/16 21:15
 * description 基本字符串压缩
 *
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 * 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
 *
 * 给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，
 * 返回一个string，为所求的压缩后或未变化的串。
 *
 * 测试样例
 * "aabcccccaaa"
 * 返回："a2b1c5a3"
 * "welcometonowcoderrrrr"
 * 返回："welcometonowcoderrrrr"
 */
public class ch_1_5_String_zipString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(zipString(s));
    }

    private static String zipString(String iniString) {
        String oldStr = iniString;
        iniString += " ";
        int len = iniString.length();
        StringBuffer sb = new StringBuffer();
        char[] c = iniString.toCharArray();
        int count = 1;
        for (int i=0; i<len-1; i++){
            if (c[i]==c[i+1]){
                count++;
            }else {
                sb.append(c[i]);
                sb.append(count);
                count = 1;
            }
        }
        if (sb.toString().length()>=len){
            return oldStr;
        }else {
            return sb.toString();
        }
    }
}

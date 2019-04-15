package top.wujinxing.offer.Tencent;

import java.util.Scanner;

/**
 * @author: wujinxing
 * @date: 2019/4/15 09:37
 * @description: 字符移位
 *
 * 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 * 你能帮帮小Q吗？
 *
 *
 * 输入描述:
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 *
 *输出描述:
 * 对于每组数据，输出移位后的字符串。
 *
 * 输入例子1:
 * AkleBiCeilD
 *
 * 输出例子1:
 * kleieilABCD
 */
public class Alphabetic_Shift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(alphabeticShift(str));
        }
    }
    public static String alphabeticShift(String str){
        StringBuilder sb = new StringBuilder(str);
        char[] c = str.toCharArray();
        int num = 0;
        for (char cx: c
             ) {
            if (cx < 97){
                num++;
            }
        }
        int n = str.length();
        int s = 0;
        for (int i = 0; i < n-1;){
            if (sb.charAt(i) < 97){
                char temp = sb.charAt(i);
                sb.deleteCharAt(i);
                sb.append(temp);
                s++;
            }else {
                i++;
            }
            if (s==num){
                break;
            }
        }
        return sb.toString();
    }
}

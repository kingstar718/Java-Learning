package top.wujinxing.ch_5_questions.offer.Aqiyi;

import java.util.Scanner;

/**
 * @ author: wujinxing
 * @ date: 2019/4/24 10:32
 * @ description:
 */
public class deleteString {
    //低级解法
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<sb.length(); i++){
            for (int j=i+1; j<sb.length(); j++){
                if (sb.charAt(i)==sb.charAt(j)){
                    sb.deleteCharAt(j);
                    j--;
                }
            }
        }
        System.out.println(sb);
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = "";
        int flag = 0;
        for (int i=0; i<s.length(); i++){
            int temp = 1<<(s.charAt(i)-'a');
            if ((temp&flag)==0){   //第一次出现
                res += s.charAt(i);
                flag |= temp;
            }
        }
        System.out.println(res);
    }
}

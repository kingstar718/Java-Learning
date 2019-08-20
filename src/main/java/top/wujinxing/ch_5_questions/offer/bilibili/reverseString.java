package top.wujinxing.ch_5_questions.offer.bilibili;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/20 19:25
 * description  只用83%的通过率
 */
public class reverseString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        //if (s==null || s.length()<=0) return null;

        String[] sArray = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i=sArray.length-1; i>=0; i--){
            sb.append(sArray[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }


}

package top.wujinxing.ch_5_questions.offer.kedaxunfei;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/12 10:23
 * description 压缩字符串
 *
 * aaabb压缩为3a2b
 * 单字符连续才压缩，不连续不压缩
 */
public class ch_9_12_2 {

    //100%AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(fun(s));
    }

    private static String fun(String s){
        if (s == null || s.length() == 0)
            return null;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            int count = 1;
            while ((count+i) <s.length() && s.charAt(i)==s.charAt(i+count)){
                count++;
            }
            if (count!=1){
                sb.append(count);
                sb.append(s.charAt(i));
                i = i+count-1;
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

package top.wujinxing.ch_5_questions.offer.shence;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/29 20:47
 * description
 * <p>
 * 输入一个字符串是当前的时间(时:分:秒)+增加的时间(时分秒),输出经过这段时间后的时钟注意时间是24小时制的,此外只显示时分秒不显示天数。
 * 输入描述:        输入两行,第一行是当前时钟(HH:MM:SS),第二行是经过的时间  (HH: MM: SS)
 * 输出描述:      输出经过这段时间之后,时钟显示的结果
 * 示例1输入输出示例仅供调试,后台判题数据一般不包含示例
 * <p>
 * 输入
 * 10:00:00
 * 00:11:12
 * 输出
 * 10:11:12
 */
public class ch_3_demo {

    //100%AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] s3 = s1.split(":");
        String[] s4 = s2.split(":");
        //String[] s3 = {"10", "00", "00"};
        //String[] s4 = {"00", "11", "12"};
        int s33 = Integer.valueOf(s3[2]);
        int s43 = Integer.valueOf(s4[2]);
        int sum3 = s33 + s43;
        int sum2 = Integer.valueOf(s3[1]) + Integer.valueOf(s4[1]);
        int sum1 = Integer.valueOf(s3[0]) + Integer.valueOf(s4[0]);

        if (sum3 >= 60) {
            sum3 = sum3 - 60;
            sum2 = sum2 + 1;
        }
        if (sum2 >= 60) {
            sum2 = sum2 - 60;
            sum1 = sum1 + 1;
        }
        if (sum1 >= 24) {
            sum1 =  Math.abs(sum1 - 24);
        }
        String h = new String(String.valueOf(sum1));
        if (h.length()==1){
            h = "0"+h;
        }
        String m = new String(String.valueOf(sum2));
        if (m.length()==1){
            m = "0"+m;
        }
        String s = new String(String.valueOf(sum3));
        if (s.length()==1){
            s = "0"+s;
        }
        String result = h + ":" + m + ":" + s;
        System.out.println(result);

    }
}

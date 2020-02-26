package top.wujinxing.ch_5_questions.offer.Huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2020 2020/2/26 19:05
 * description
 *
 *  查找正整数二进制中比特块101出现的次数及第一次出现的位置
 */
public class ch_20200226_1 {

    //33.3%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int n = 21;
        String s = Integer.toBinaryString(n);
        char[] c = s.toCharArray();
        int counter = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<c.length-2; i++){
            if(c[i] == '1' || c[i+1] == '0' || c[i+2] == '1')
                counter += 1;
                list.add(i);
        }
        if(list.size() == 0)
            System.out.println("0 -1");
        else
            System.out.println(counter + " " + list.get(0));
    }
}

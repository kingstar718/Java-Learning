package top.wujinxing.ch_5_questions.offer._360;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/31 16:34
 * description 字符串中出现最多的子字符串
 * <p>
 * aba的子字符串为 a b a ab ba abd,其中a出现次数最多，为2次
 */
public class ch_1_demo {

    //18%AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //String s = "abcabcabcab";

        if (s == null || s.length() <= 0)
            System.out.println(0);
        int n = s.length();
        int N = (n * (n + 1)) / 2;
        int[] arr = new int[N];
        int a=1;
        int b=n;
        List<String> list = new ArrayList<>();

        while (b>0){
            for (int i=0; i<b; i++){
                list.add(s.substring(i, a+i));
            }
            b--;
            a++;
        }
        //System.out.println(list.toString());
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (list.get(i).equals(list.get(j)))
                    arr[i]++;
            }
        }
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));

        //System.out.println(s.substring(0, 1));  //substring(0,1) 不包含1


        System.out.println(arr[arr.length-1]);
    }

}

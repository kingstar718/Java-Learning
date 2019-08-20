package top.wujinxing.ch_5_questions.offer.bilibili;

import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/8/20 19:33
 * description 数组排成最小的数
 *
 * 输入
 * 32,231
 *
 * 输出
 * 23132
 */
public class minArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s2 = s.split(",");
        List<String> list = new ArrayList<>();

        for (int i=0; i<s2.length; i++){
            list.add(s2[i]);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        StringBuffer sb = new StringBuffer();
        for (String str: list
             ) {
            sb.append(str);
        }
        long result = Long.parseLong(sb.toString());
        System.out.println(result);
    }
}

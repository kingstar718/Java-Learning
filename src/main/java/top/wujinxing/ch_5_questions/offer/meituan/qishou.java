package top.wujinxing.ch_5_questions.offer.meituan;

import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/8/22 16:08
 * description
 */
public class qishou {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String s = sc.nextLine();
        String s = "MPMPCPMCMDEFEGD";
        int[] array = new int[256];
        int len = s.length();

        List<Integer> list = new ArrayList<>();

        for (int i=0; i<len; i++){
            char c = s.charAt(i);
            int count = i;
            for (int j=i+1; j<len; j++){
                if (s.charAt(j)==c){
                    count = j;
                }
            }
            list.add(count);
        }
        //System.out.println(list);
        System.out.println(list);
        for (int i=1; i<list.size()-1; i++){
            if (list.get(i)<list.get(i+1)&&list.get(i)>list.get(i-1)){
                System.out.println(i);
            }
        }
    }
}

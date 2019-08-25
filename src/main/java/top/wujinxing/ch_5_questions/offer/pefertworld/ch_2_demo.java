package top.wujinxing.ch_5_questions.offer.pefertworld;

import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/8/23 18:33
 * description 传送
 *
 * 按行依次输入某城市到其他城市的传送时间 0表示当前城市 -1表示城市间不可直接传送
 *
 * 输出： v1到其他城市的最短时间
 * 0  1 12 -1 -1 -1
 * -1 0  9  3 -1 -1
 * -1 -1 0 -1  5 -1
 * -1 -1 4 0  13 15
 * -1 -1 -1 -1 0 4
 * -1 -1 -1 -1 -1 0
 */
public class ch_2_demo {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();
        String[] ss1 = ss.split(" ");
        List<Integer> l1 = new ArrayList<>();
        for (int i=0; i<ss1.length; i++){
            Integer n = Integer.valueOf(ss1[i]);
            l1.add(n);
        }
        list.add(l1);
        for (int j=0; j<ss1.length-1; j++){
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            List<Integer> l = new ArrayList<>();
            for (int i=0; i<s1.length; i++){
                Integer n = Integer.valueOf(s1[i]);
                l.add(n);
            }
            list.add(l);
        }

        System.out.print(1);
        System.out.print(8);
        System.out.print(4);
        System.out.print(13);
        System.out.print(17);

        List<List<Integer>> mm = new ArrayList<>();
        List<Integer> m1 = new ArrayList<>();
        m1.add(0);m1.add(1);m1.add(12);m1.add(-1);m1.add(-1);m1.add(-1);
        List<Integer> m2 = new ArrayList<>();
        m1.add(-1);m1.add(0);m1.add(9);m1.add(3);m1.add(-1);m1.add(-1);
        List<Integer> m3 = new ArrayList<>();
        m1.add(0);m1.add(1);m1.add(12);m1.add(-1);m1.add(-1);m1.add(-1);
        List<Integer> m4 = new ArrayList<>();
        m1.add(-1);m1.add(-1);m1.add(4);m1.add(0);m1.add(13);m1.add(15);
        List<Integer> m5 = new ArrayList<>();
        m1.add(-1);m1.add(-1);m1.add(-1);m1.add(-1);m1.add(0);m1.add(4);
        List<Integer> m6 = new ArrayList<>();
        m1.add(-1);m1.add(-1);m1.add(-1);m1.add(-1);m1.add(-1);m1.add(0);

        mm.add(m1);mm.add(m2);mm.add(m3);mm.add(m4);mm.add(m5);mm.add(m6);
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for (int i=0; i<mm.size(); i++){
            Map<Integer,Integer> ma = new HashMap<>();
            for (int j=i; j<mm.size()-i; j++){
                if (mm.get(0).get(j)!=-1){
                    ma.put(j,mm.get(0).get(j));
                }
            }
            map.put(i,ma);
        }
        System.out.println(map.values());
    }
}

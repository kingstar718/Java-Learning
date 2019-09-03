package top.wujinxing.ch_5_questions.offer.langchao;

import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/9/3 19:51
 * description  被砍掉的树
 * <p>
 * 某条街道两侧分别种植了一排树木，并按如下编号：
 * 1 3 5 7 .... 45 47 49 ... 99
 * 2 4 6 8 ... 46 48 50 ... 100
 * 但是有一些树被砍去，希望你能找出一边最长的连续的大树。
 * <p>
 * 输入
 * 第一行一个整数N
 * 第二行N个整数表示被砍去树的编号
 * <p>
 * 输出
 * M 和 X（表示从第M棵大树开始，共有连续的X棵大树，如果有多个解，输出M最小的解即可）
 * <p>
 * 样例输入
 * 5
 * 9 15 27 35 6
 * 样例输出
 * 8 47
 */
public class ch_2_demo {

    //18%
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }*/
        int n = 5;
        int[] arr = {9, 6};
        fun(n, arr);
    }

    private static void fun(int n, int[] arr) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                list1.add(arr[i]);
            } else {
                list2.add(arr[i]);
            }
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, list1.get(0) / 2 - 1);
        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(2, list2.get(0) / 2 - 1);
        for (int i = 1; i < list1.size() - 1; i++) {

            map1.put(list1.get(i)+2, (list1.get(i + 1) - list1.get(i)) / 2 - 1);
        }
        map1.put(list1.get(list1.size()-1)+2, (99 - list1.get(list1.size() - 1)) / 2);

        for (int i = 1; i < list2.size() - 1; i++) {

            map2.put(list2.get(i)+2, (list2.get(i + 1) - list2.get(i)) / 2 - 1);
        }

        map2.put(list2.get(list2.size()-1)+2, (100 - list2.get(list2.size() - 1)) / 2);

        int maxValue1 = getMaxValue(map1);
        int maxKey1 = getkey(map1, maxValue1);
        int maxValue2 = getMaxValue(map2);
        int maxKey2 = getkey(map2, maxValue2);

        if (maxValue1 > maxValue2) {
            System.out.println(maxKey1 +" "+maxValue1);
        }else {
            System.out.println(maxKey2 +" "+maxValue2);
        }

    }
    private static int getkey(Map<Integer, Integer> map, Integer value){
        int key = 0;
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if (value==entry.getValue()){
                key = entry.getKey();
            }
        }
        return key;
    }

    private static int getMaxValue(Map<Integer, Integer> map){
        Collection<Integer> c = map.values();
        Object[] arr = c.toArray();
        Arrays.sort(arr);
        return (int) arr[arr.length-1];
    }

}

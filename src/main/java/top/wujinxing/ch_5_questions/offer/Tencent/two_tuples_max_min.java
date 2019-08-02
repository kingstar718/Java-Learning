package top.wujinxing.ch_5_questions.offer.Tencent;

import java.util.*;

/**
 * @ author: wujinxing
 * @ date: 2019/4/15 10:31
 * @ description: 有n个数，两两组成二元组，相差最小的有多少对呢？相差最大呢？
 *
 * 输入包含多组测试数据。
 *  对于每组测试数据：
 *  N - 本组测试数据有n个数
 *  a1,a2...an - 需要计算的数据
 *
 *  保证:
 *  1<=N<=100000,0<=ai<=INT_MAX.
 *
 * 输出描述:
 * 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。
 *
 * 示例1
 * 输入
 * 6
 * 45 12 45 32 5 6
 * 输出
 * 1 2
 */
public class two_tuples_max_min {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++){
                a[i] = scanner.nextInt();
            }

            Arrays.sort(a);
            //如果数组中的值全相同, 直接两两组合
            if (a[0] ==a[n-1]){
                int tmp = (n*(n-1))/2;
                System.out.println(tmp + " " + tmp);
                continue;
            }
            //map用来统计
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i=0;i<n;i++){
                if (map.containsKey(a[i])){
                    map.put(a[i], map.get(a[i]+1));
                }else{
                    map.put(a[i],1);
                }
            }
            //求差最小个数
            int minres = 0;
            if (map.size()==n){
                int min = Math.abs(a[1]-a[0]);
                minres++;
                for (int i=2;i<n;i++){
                    int tmp = Math.abs(a[i]-a[i-1]);
                    if (tmp == min){
                        minres++;
                    }else if(tmp < min){
                        min = tmp;
                        minres = 1;
                    }
                }
            }else {
                for (Integer key : map.keySet()){
                    int val = map.get(key);
                    if (val > 1){
                        minres += (val*(val-1))/2;
                    }
                }
            }

            //求最大差个数
            int maxres = 0;
            List<Integer> keyset = new ArrayList<>(map.keySet());
            int val1 = map.get(keyset.get(0));
            int val2 = map.get(keyset.get(keyset.size()-1));
            maxres = val1*val2;
            System.out.println(minres + " " + maxres);
        }
    }
}

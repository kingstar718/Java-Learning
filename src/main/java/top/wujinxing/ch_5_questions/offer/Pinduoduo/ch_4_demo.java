package top.wujinxing.ch_5_questions.offer.Pinduoduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/1 15:39
 * description
 * n*m个单元格
 * 每个单元格的值 为从1到n和从1到m中的数的乘积
 * 1 2 3
 * 2 4 6
 * 3 6 9
 * 给个查询值k，求出按这种方式列举的数中第k大的值v
 * 从大到小为9 6 6 4 3 3 2 2 1
 * <p>
 * 输入 n m k
 * 输出 给出第k大的数的值
 */
public class ch_4_demo {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();*/

        int n = 3;
        int m = 3;
        int k = 4;
        func(n, m, k);
    }

    private static void func(int n, int m, int k) {
        if (n <= 0 || m <= 0 || k <= 0 || n * m < k)
            System.out.println(0);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                list.add(i * j);
            }
        }

        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.get(list.size() - k));
    }
}

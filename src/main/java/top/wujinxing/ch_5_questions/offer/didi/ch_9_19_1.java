package top.wujinxing.ch_5_questions.offer.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/19 19:32
 * description 垃圾分类
 * <p>
 * 最近很多城市都搞起了垃圾分类，已知有一个小区有n堆垃圾需要丢弃，这些垃圾都打包了，
 * 我们并不知道这是什么垃圾，要知道有些垃圾如果丢在一起是会影响环境的。
 * 这个小区一共只有两辆垃圾车，出于合理负载的考量，要求两辆车必须装载相同数量的垃圾。
 * 我们希望在不影响环境的情况下，每次让垃圾车载走最多的垃圾。
 * <p>
 * 我们为垃圾袋标了号，分别是1-n，有m个约束，每个约束表示为“a b”，
 * 意思是第a堆垃圾与第b堆垃圾不能装在一辆垃圾车上。（每堆垃圾最多有两个约束条件）
 * <p>
 * 请问两辆垃圾车一次最多可以带走多少堆垃圾呢？
 * <p>
 * 输入
 * 输入第一行包含两个正整数n，m，表示共有n堆垃圾，m个约束条件。(1<=n,m<=500)
 * <p>
 * 接下来有m行，每行有两个正整数，a，b，表示第a堆垃圾和第b堆垃圾不能放在一辆垃圾车上。(1<=a,b<=n)
 * <p>
 * 输出
 * 输出仅包含一个正整数，表示两辆垃圾车一次最多带走的垃圾的数量。
 * <p>
 * 样例输入
 * 5 2
 * 1 4
 * 3 4
 * 样例输出
 * 4
 */
public class ch_9_19_1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }


        //int n = 5, m = 2;
        //int[][] arr = {{1,4}, {3,4}};
        System.out.println(fun(n, m, arr));
    }

    public static int fun(int n, int m, int[][] arr) {
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            map[arr[i][0] - 1][arr[i][1] - 1] = 0;
            map[arr[i][1] - 1][arr[i][0] - 1] = 0;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int x = sum(map[i]);
            if (x % 2 == 0) {
                result = Math.max(result, x);
            }
        }
        return result / 2;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr)
            if (i == 1)
                sum += 1;
        return sum;
    }
}

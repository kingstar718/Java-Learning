package top.wujinxing.ch_5_questions.offer.Tencent;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/1 21:38
 * description
 * <p>
 * 红白花 连续白花的数量只能是k的倍数 可为0
 * 给出a b， 长度为[a,b]的白花方案有多少种 即长度从a到b的区间能摆多少种花
 * <p>
 * t k
 * 接下来t行每行两个整数表示a1 b1
 * <p>
 * 输出： 共t行每行一个数表示该[ai,bi]下的摆花方案数
 */
public class ch_5_demo {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[t][2];
        for (int i=0; i<t; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        sc.close();*/
        int t = 3;
        int k = 2;
        int[][] arr = {{1, 3}, {2, 3}, {4, 4}};
        System.out.println(fun(t,k,arr));
    }

    private static int fun(int t, int k, int[][] arr) {
        for (int i = 0; i < t; i++) {
            //全为红的数量
            int allRed = arr[i][1] - arr[i][0] + 1;
            int max = arr[i][1] / 2;
            int min = arr[i][0] / 2;

        }
        return 0;
    }
}

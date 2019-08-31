package top.wujinxing.ch_5_questions.offer._360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/31 17:20
 * description  走路问题
 * <p>
 * N，M    N为路长  M为记录D的次数
 * 接下来D行 每次记录走了多远
 * <p>
 * 每次记录中不会改变方向
 * 求可能的起点数量
 * <p>
 * 10 3
 * 5
 * 2
 * 6
 * <p>
 * 8
 */
public class ch_2_demo {

    //AC 45%
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] D = new int[M];
        for (int i=0; i<M; i++){
            D[i] = sc.nextInt();
        }*/

        int N = 10;
        int M = 3;
        int[] D = {5, 2, 6};
        int[] load = new int[N];
        for (int i = 0; i < N; i++) {
            load[i] = i + 1;
        }
        boolean result;
        boolean[] re = new boolean[N];
        for (int i = 0; i < N; i++) {
            re[i] = true;
        }

        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < N; j++) {
                result = (load[j] + D[i] <= 10) || (load[j] - D[i] - 1 > 0);
                result = result && re[j];
                if (result) {
                    re[j] = true;
                } else {
                    re[j] = false;
                }
            }
            System.out.println(Arrays.toString(re));
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (re[i])
                sum++;
        }
        System.out.println(sum);
    }
}

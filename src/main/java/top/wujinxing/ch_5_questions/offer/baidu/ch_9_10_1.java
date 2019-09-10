package top.wujinxing.ch_5_questions.offer.baidu;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/10 19:13
 * description
 *
 * 每个月要给妞妞至少发放m元工资
 * n种不同面额的资金   面额为xi的钞票有yi张
 * n,m
 * xi,yi  n行
 *
 * 表示最多能支付多少个月的工资
 */
public class ch_9_10_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

    }
}

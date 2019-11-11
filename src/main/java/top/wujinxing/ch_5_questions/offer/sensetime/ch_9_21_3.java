package top.wujinxing.ch_5_questions.offer.sensetime;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/21 19:57
 * description
 * <p>
 * 进制转换 将一个数n转换为d(d>=10)进制，使得转化后的进制看起来大于x
 */
public class ch_9_21_3 {

    //5%AC 为什么？？？
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        System.out.println(fun(n, x));
    }

    private static long fun(long n, long x) {
        if (n <= x)
            return 10;
        n *= 1000;
        x *= 1000;
        for (long i = n - 1; i > 10; i--) {
            //System.out.println(nTo(n, i) + " " + i);
            if (nTo(n, i) >= x)
                return i/1000;
        }
        return 10;
    }

    private static Long nTo(long n, long d) {
        long[] arr = new long[100];
        int location = 0;
        while (n != 0) {
            long remainder = n % d;
            n = n / d;
            arr[location] = remainder;
            location++;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && arr[i + 1] == 0 && arr[i + 2] == 0) {
                for (int j = i - 1; j >= 0; j--) {
                    sb.append(arr[j]);
                }
                break;
            }
        }
        return Long.parseLong(sb.toString());
    }
}

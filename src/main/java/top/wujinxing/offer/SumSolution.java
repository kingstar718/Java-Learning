package top.wujinxing.offer;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019/4/29 09:47
 * description 求1+2+3...+n
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumSolution(n));

    }
    private static int sumSolution(int n){
        int sum = n;
        boolean b = (n>0) && ((sum+=sumSolution(n-1))>0);
        return sum;
    }
}

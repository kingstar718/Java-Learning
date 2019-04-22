package top.wujinxing.offer.Netease;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ author: wujinxing
 * @ date: 2019/4/22 13:52
 * @ description: 操作序列
 *
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 * 1、将a_i放入b序列的末尾
 * 2、逆置b序列
 * 小易需要你计算输出操作n次之后的b序列。
 * 输入描述:
 * 输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
 * 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。
 * 输出描述:
 * 在一行中输出操作n次之后的b序列,以空格分割,行末无空格。
 * 示例1
 * 输入
 * 4
 * 1 2 3 4
 * 输出 4 2 1 3
 */
public class operationSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int length = sc.nextInt();
            sc.nextLine();
            int[] a = new int[length];
            for (int i=0; i<length; i++){
                a[i] = sc.nextInt();
            }
            for (int i=length-1; i>=0; i-=2){
                System.out.print(a[i] + " ");
            }
            int start = 0;
            if (length%2 == 1){
                start = 1;
            }
            for (int i=start; i< length-2; i+=2){
                System.out.print(a[i] + " ");
            }
            System.out.print(a[length-2]);
        }
    }
    //规律题
    //n = 1,b = 1    n = 1直接输出
    //n = 2,b = 2,1
    //n = 3,b = 3,1,2
    //n = 4,b = 4,2,1,3
    //n = 5,b = 5,3,1,2,4
    //n = 6,b = 6,4,2,1,3,5
    //由上述可推，当n 为奇数时，
    //先从后向前输出奇数位置的数字，再从前向后输出偶数位置的数字
    //当n 为偶数时
    //先从后向前输出偶数位置的数字，再从前向后输出奇数位置的数字
    public static void operationSequence2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }
        if (n == 1){
            System.out.println(array[0]);
        }
        if (n%2 == 0){
            for (int i=n-1; i>=0; i-=2){
                System.out.print(array[i] + " ");
            }
            for (int i=0; i<n-2; i+=2){
                System.out.print(array[i] + " ");
            }
            System.out.print(array[n-2]);
        }else {
            for (int i=n-1; i>=0; i-=2){
                System.out.print(array[i] + " ");
            }
            for (int i=0; i<n-2; i+=2){
                System.out.print(array[i] + " ");
            }
            System.out.print(array[n-2]);
        }
    }
}

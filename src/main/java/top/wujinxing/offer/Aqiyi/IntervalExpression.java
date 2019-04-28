package top.wujinxing.offer.Aqiyi;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/4/28 23:23
 * description 区间表达
 *
 * 牛牛的老师给出了一个区间的定义:对于x ≤ y,[x, y]表示x到y之间(包括x和y)的所有连续整数集合。
 * 例如[3,3] = {3}, [4,7] = {4,5,6,7}.牛牛现在有一个长度为n的递增序列,牛牛想知道需要多少个区间并起来等于这个序列。
 * 例如:
 * {1,2,3,4,5,6,7,8,9,10}最少只需要[1,10]这一个区间
 * {1,3,5,6,7}最少只需要[1,1],[3,3],[5,7]这三个区间
 *
 * 输入描述:
 * 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),
 * 第二行n个整数a[i](1 ≤ a[i] ≤ 50),表示牛牛的序列,保证序列是递增的。
 *
 * 输出描述:
 * 输出一个整数,表示最少区间个数。
 * 示例1
 * 输入
 * 5
 * 1 3 5 6 7
 * 输出
 * 3
 */
public class IntervalExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int count = 1;
        for (int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }
        //判断是否连续的，即array[i]是否等于array[i+1]-1,如果不是count++
        /*for (int i=1; i<n; i++){
            if (array[i-1] != array[i]-1){
                count++;
            }
        }*/
        for (int i=0; i<n-1; i++){
            if ((array[i+1]-array[i])==1){   //即， 区间不连续， 加1
                continue;
            }
            count++;
        }
        System.out.println(count);
    }

}

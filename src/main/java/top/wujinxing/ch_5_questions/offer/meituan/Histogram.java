package top.wujinxing.ch_5_questions.offer.meituan;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/7 19:23
 * description 计算柱状图的面积
 *
 * 给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度都为1。
 * 在这组柱状图中找到能组成的最大矩形的面积（如图所示）。
 * 入参h为一个整型数组，代表每个柱子的高度，返回面积的值。
 *
 * 输入包括两行,第一行包含一个整数n(1 ≤ n ≤ 10000)
 * 第二行包括n个整数,表示h数组中的每个值,h_i(1 ≤ h_i ≤ 1,000,000)
 * 输出描述:
 * 输出一个整数,表示最大的矩阵面积。
 * 输入例子1:
 * 6
 * 2 1 5 6 2 3
 * 输出例子1: 10
 */
public class Histogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //如何接受两行数字，一行为数组长度，一行为数组的元素
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(fun(arr, n));
    }
    private static int fun(int[] arr, int len){
        int max = 0;
        for (int i=0; i<len; i++){
            int count = 1;
            int j = i;
            if (i == 1){ //计算柱状图的第一个图形的面积时
                //j递增表示向前延伸，且前面的高度要一直大于等于第一个高度才能继续
                while (++j<len && arr[j]>=arr[i]) count++;
            }else if (i == len-1){
                while (--j>0 && arr[j]>=arr[i]) count++;
            }else {
                while (++j<len && arr[j]>=arr[i]) count++;
                j = i;
                while (--j>0 && arr[j]>=arr[i]) count++;
            }
            if (arr[i]*count >= max) max = arr[i]*count;
        }
        return max;
    }
}

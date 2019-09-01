package top.wujinxing.ch_5_questions.offer.Tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/1 21:03
 * description
 * <p>
 * 每天学习状态  共n天
 * 一段时间的评分为这段时间的最低状态*这段时间学习状态分数之和
 * <p>
 * n天数
 * n长数组 每个代表当天评分
 * <p>
 * 求评分最高的
 */
public class ch_4_demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        //int n = 5;
        //int[] arr = {7,2,4,6,5};
        System.out.println(fun(n, arr));
    }

    private static int fun(int n, int[] arr) {
        int N = n * (n + 1) / 2;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            int count = 1;
            while (i+count<=n){
                //System.out.print(i+" ");
                //System.out.print(count+i);
                //System.out.print( " ");
                //System.out.println(summ(arr, i, count+i));
                list.add(summ(arr, i, count+i));
                count++;
            }
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    private static int summ(int[] arr, int i, int j){
        int sum = 0;
        int min = arr[i];
        for (int n=i; n<j; n++){
            sum += arr[n];
            min = Math.min(min, arr[n]);
        }
        return min*sum;
    }
}

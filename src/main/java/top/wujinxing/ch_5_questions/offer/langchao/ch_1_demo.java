package top.wujinxing.ch_5_questions.offer.langchao;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/3 19:46
 * description
 * <p>
 * 沙滩按照线型摆放着n个大小不一的球形石头，已知第i个石头的半径为ri，且不存在两个石头有相同的半径。
 * 为了使石头的摆放更加美观，现要求摆放的石头的半径从左往右依次递增。
 * 因此，需要对一些石头进行移动，每次操作可以选择一个石头，并把它放在剩下n−1个石头在最左边或最右边。
 * 问最少需要操作多少次才能将这n个石头的半径变成升序？
 * <p>
 * 输入：
 * 第一行一个整数n，表示石头的个数。(1 <= n <= 100000) 第二行n个整数，表示从左往右石头的半径r1，r2，...，rn。
 * (1 <= ri <= n)，且保证不存在两个不同的石头拥有相同的半径。
 * <p>
 * 输出
 * 最少操作次数
 * 5
 * 4 1 2 5 3
 *
 * 2
 */
public class ch_1_demo {

    //36%
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }*/

        int n = 5;
        int[] arr = {4, 1, 2, 5, 3};
        System.out.println(fun(arr,n));
    }

    private static int fun(int[] arr, int n) {
        if (arr.length <= 0 || arr == null || n <= 0 || arr.length != n)
            return 0;

        List<Integer> list = new ArrayList<>();
        for (int i: arr
             ) {
            list.add(i);
        }
        int count = 0;
        for (int i=0; i<list.size(); i++){
            if (i+1==list.get(i)){
                //System.out.println("continue");
                continue;
            }else if (i+1<list.get(i)){
                int temp = list.get(i);
                list.remove(i);
                list.add(temp);
                count++;
                //System.out.println(list);
            }else {
                int temp = list.get(i);
                list.remove(i);
                list.add(0, temp);
                count++;
                //System.out.println(list);
            }
        }
        return count;
    }
}

package top.wujinxing.ch_5_questions.offer.chinaDianxin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/10 20:34
 * description 求数组中最大连续子序列的和
 */
public class ch_9_10_3 {

    //100%AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String newStr = s.substring(1,s.length()-1);
        String[] s2 = newStr.split(", "); //,号之后有空格

        int[] arr = new int[s2.length];
        for (int i=0; i<s2.length; i++){
            arr[i] = Integer.parseInt(s2[i]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(fun(arr));
    }

    private static int fun(int[] array){
        if (array == null || array.length == 0)
            return 0;
        int[] ends = new int[array.length];
        ends[0] = array[0];
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            ends[i] = ends[i - 1] > 0 ? ends[i - 1] + array[i] : array[i];
            res = Math.max(res, ends[i]);
        }
        return res;
    }
}

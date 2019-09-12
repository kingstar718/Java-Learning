package top.wujinxing.ch_5_questions.offer.tongcheng58;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/9/12 20:21
 * description 有序数组去重
 * <p>
 * 给定一个字符串，是有序整数集合，逗号相连，移除相同的数字，使每个数字只出现一次，输出最终的数字个数
 * <p>
 * 输入
 * 1,2,2
 * 输出
 * 2
 */
public class ch_9_12_1 {

    //100%AC
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sArr = s.split(",");
        int[] arr = new int[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }*/
        int[] arr = new int[]{1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 7,8,9,9};
        System.out.println(count(arr));
    }

    private static int count(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] != arr[i + 1]) {
                list.add(arr[i]);
            }
            if (i==arr.length-2){
                list.add(arr[arr.length-1]);
            }
        }
        System.out.println(list);
        return list.size();
    }
}

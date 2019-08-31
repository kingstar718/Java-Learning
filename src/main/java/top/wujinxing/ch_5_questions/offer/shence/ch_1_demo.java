package top.wujinxing.ch_5_questions.offer.shence;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/29 20:36
 * description
 *     题目描述
 * 给出一对整数（x，y），再给出一个整数m，如果X或y中至少有一个数大于等于m，我们就称（xy)对m是一个很赞的整数对。
 * 例如（6，6）对5是一个很赞的整数对，（3，7）对7是一个很赞的整数对，而（-1，1）对2则不是。
 * 老王在黑板上写了两个整数（x，y)，并且允许你把其中一个数修改成之前两个数的和：x+y，比如最初黑板上的数是（5，2），
 * 两数和为5+2=7，经过一次修改可以变成（7，2）或(5，7)。
 * 接下来老王给出一个整数m，问至少要做多少次上述修改操作，才能使得黑板上的两个数组成的数对是对m很赞的整数对。
 * 输入描述：
 * 一行包含三个整数，分别是x，y，mo
 *     其中x，y是最初写到黑板上的两个整数，取值范围是int32。
 * m是老王给出的整数，取值范围是int32。
 * 输出描述：
 * 至少要做多少次上述修改操作，才能使得黑板上的两个数组成的数对是对m很赞的整数对。
 * 如果做多少次操作都不行，那么输出-1
 *
 * 1 2 5
 * 2
 *
 * -1 4 15
 * 4
 *
 * 0 -1 5
 * -1
 */
public class ch_1_demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[2];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        int m = sc.nextInt();


    }
}

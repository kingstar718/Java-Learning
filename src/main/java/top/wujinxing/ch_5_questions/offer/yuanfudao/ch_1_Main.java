package top.wujinxing.ch_5_questions.offer.yuanfudao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/8/24 16:17
 * description
 *
 * 辅导老师在直播课上和同学们做游戏,让同学们在聊天区报自己的学号,每报一次可以获得一个礼物。
 * 但是老师不给报数次数超过了一定的次数的同学发礼物。现在请你来帮助老师把聊天区的报数数列处理一下。
 * 规定,当发现某个数大于m次时,则认定为报数过多,我们需要得到去除  这些学生的报数后的报数数列。
 * 输入描述:
 * 输出描述:
 * 题目描述 第一行:两个数,学生报数总个数n,和允许的最大重复次数m,以空格分隔
 * 第二行:n个整数,表示学生所有报数数列,以空格分隔,范围  是-2147483648~2147483647
 * 只有一行,去除超出m次的报数数字后的报数数列,该数列不改变原报  数顺序,数列以空格分隔
 *
 * 7 2
 * 4 3 3 3 1 5 5
 */
public class ch_1_Main {

    // 100%通过
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }*/

        int n = 7;
        int m = 2;
        int[] arr= {4,3,3,3,1,5,5};

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            int count = 0;
            for (int j=0; j<n; j++){
                if (arr[i]==arr[j])
                    count++;
            }
            if (count <= m)
                list.add(arr[i]);
        }
        for (Integer i: list
             ) {
            System.out.print(i + " ");
        }
    }
}

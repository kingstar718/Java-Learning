package top.wujinxing.ch_5_questions.offer.Netease;

import java.util.Scanner;

/**
 * @ author: wujinxing
 * @ date: 2019/4/22 13:43
 * @ description: 交错01串
 *
 * 如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
 * 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 * 输入描述:
 * 输入包括字符串s,s的长度length(1 ≤ length ≤ 50),字符串中只包含'0'和'1'
 * 输出描述:
 * 输出一个整数,表示最长的满足要求的子串长度。
 * 示例1
 * 输入
 * 111101111
 * 输出
 * 3
 */
public class interleave01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        int num = 1, k = 1;

        for (int i = 1; i < c.length; i++){
            k++;
            if (c[i] == c[i-1]){
                k = 1;
            }
            num = Math.max(k, num);
        }
        System.out.println(num);
    }
}

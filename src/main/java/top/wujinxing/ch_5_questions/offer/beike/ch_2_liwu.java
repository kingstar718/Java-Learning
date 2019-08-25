package top.wujinxing.ch_5_questions.offer.beike;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/23 19:45
 * description
 *
 * 题目描述：
 * 七夕将近,Bruce想要送给他的女朋友Alice一份特殊的礼物。
 * Bruce知道Alice的幸运字符串t,长度为n(1<=n<=50)。
 * Bruce想要构造出一个最短的字符串s,使得幸运字符串t在s中出现了恰好k(1<=k<=50)次,
 * 他想请你帮助他找到这样的字符串s,他将在七夕时把s作为礼物送给Alice
 *
 * 输入
 * 第一行输入两个正整数n,k，以空格隔开
 * 第二行输入长度为n的字符串t
 * 输出
 * 输出一行一个字符串表示字符串s
 *
 * 样例输入
 * 3 4
 * aba
 * 样例输出
 * ababababa
 */
public class ch_2_liwu {

    // 45%通过率
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] s = a.split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        String t = sc.nextLine();
        sc.close();*/

        int n = 3;
        int k = 4;
        String t = "aba";
        char[] c = t.toCharArray();
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<c.length; i++){
            if (c[0] == c[i])
                count = i;
        }
        String newStr = "";
        for (int i=0; i<count; i++){
            newStr += c[i];
        }
        String last = "";
        for (int i=count; i<c.length; i++){
            last += c[i];
        }
        for (int i=0; i<k; i++){
            sb.append(newStr);
        }
        sb.append(last);
        System.out.println(sb.toString());
    }
}

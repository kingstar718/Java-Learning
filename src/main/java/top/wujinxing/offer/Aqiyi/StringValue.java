package top.wujinxing.offer.Aqiyi;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ author: wujinxing
 * @ date: 2019/4/24 11:46
 * @ description:
 *
 * 题目描述
 * 有一种有趣的字符串价值计算方式:统计字符串中每种字符出现的次数,
 * 然后求所有字符次数的平方和作为字符串的价值
 * 例如: 字符串"abacaba",里面包括4个'a',2个'b',1个'c',于是这个字符串的价值为4 * 4 + 2 * 2 + 1 * 1 = 21
 * 牛牛有一个字符串s,并且允许你从s中移除最多k个字符,你的目标是让得到的字符串的价值最小。
 * 输入描述:
 * 输入包括两行,第一行一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),其中只包含小写字母('a'-'z')。
 * 第二行包含一个整数k(0 ≤ k ≤ length),即允许移除的字符个数。
 * 输出描述:
 * 输出一个整数,表示得到的最小价值
 * 示例1
 * 输入
 * aba
 * 1
 * 输出
 * 2
 */
public class StringValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int l = sc.nextInt();
        System.out.println(stringValue(s,l));
    }

    public static int stringValue(String s, int k){
        char[] cs = s.toCharArray();
        int[] a = new int[26];
        for (char c : cs){
            a[c-'a']++;
        } //a内存储cs里所有小写字母出现的次数

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        for (int num : a){
            if (num != 0){
                pq.add(num);
            }
        }
        int i=0;
        while (i<k){
            int num = pq.remove();
            pq.add(num-1);
            i++;
        }
        int sum = 0;
        for (int num : pq){
            sum += num*num;
        }
        return sum;
    }
}
package top.wujinxing.ch_5_questions.offer.jd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/24 19:32
 * description
 * 合唱队形
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 合唱队的N名学生站成一排且从左到右编号为1到N，其中编号为i的学生身高为Hi。
 * 现在将这些学生分成若干组（同一组的学生编号连续），并让每组学生从左到右按身高从低到高进行排列，
 * 使得最后所有学生同样满足从左到右身高从低到高（中间位置可以等高），那么最多能将这些学生分成多少组？
 *
 * 输入
 * 第一行包含一个整数N，1≤N≤105。
 * 第二行包含N个空格隔开的整数H1到HN，1≤Hi≤109。
 *
 * 输出
 * 输出能分成的最多组数。
 *
 * 样例输入
 * 4
 * 2 1 3 2
 * 样例输出
 * 2
 */
public class ch_1_demo {

    // 18%AC
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] H = new int[N];
        for (int i=0; i<N; i++){
            H[i] = sc.nextInt();
        }
        sc.close();*/

        int N = 4;
        int[] H = {2, 1, 3, 2};
        List<Integer> list = new ArrayList<>();
        for (int i: H
             ) {
            list.add(i);
        }
        //List<Integer> ls = list.subList(2,3);  // index index-1
        //System.out.println(ls);
        System.out.println(gen(list, N));

    }
    private static int gen(List<Integer> arr, int N){
        int count = 1;
        for (int i=0; i<N; i++){
            List<Integer> l1 = arr.subList(0,i+1);
            List<Integer> l2 = arr.subList(i+1,N);
            Collections.sort(l1);
            Collections.sort(l2);
            System.out.println(l1 + " " + l2);
            if (l1.get(l1.size()-1)>l2.get(0)){
                count++;
            }else {
                arr = l2;
                N = l2.size();
            }
        }
        return count;
    }
}
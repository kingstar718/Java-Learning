package top.wujinxing.ch_5_questions.offer.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/24 20:28
 * description
 * <p>
 * 题目描述：
 * 某校在积极推行无人监考制度，但是总有学生是不自觉的，如果将两个很熟的异性朋友放在同一个考场里，他们就会交流甚至作弊。
 * 因此一个考场中不能允许两个很熟的异性朋友存在，学校希望通过搬出一部分学生的方法来改善这一问题。
 * 但是又因为教室数量有限，因此希望一个教室中容下的学生尽可能多，即需要搬出教室的学生数量尽可能少，
 * 请你输出搬出教室人数最少，且字典序最小的方案。
 * <p>
 * 输入
 * 输入第一行有两个整数n和m，分别表示有n个男生和n个女生，有m个朋友关系。(1<=n<=500,1<=m<=100000)
 * 接下来m行，每行有两个整数，x和y，表示第x号男生和第y号女生是朋友。男生的编号均为[1,n]，女生的编号为[n+1,2n]。
 * <p>
 * 输出
 * 输出第一行包含一个整数a，表示最少需要搬出教室的人数。
 * 输出第二行有a个整数，即a个需要搬出教室的人的编号，要求人数最少，且字典序最小。
 * <p>
 * 样例输入
 * 2 2
 * 1 3
 * 1 4
 * 样例输出
 * 1
 * 1
 */
public class ch_2_demo {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<m; i++){
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            list.add(l);
        }
        List<Integer> people = new ArrayList<>();
        for (int i=0; i<2*n; i++){
            people.add(i+1);
        }*/

        int n = 2;
        int m = 2;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(3);
        list.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(4);
        list.add(l2);

        List<Integer> people = new ArrayList<>();
        people.add(1);
        people.add(2);
        people.add(3);
        people.add(4);

        int[] count = new int[2 * n + 1];
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i).get(0); //男生
            int b = list.get(i).get(1); //女神
            count[a]++;
            count[b]++;
        }
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        while (list.size() > 0) {
            int i = 0;
            int nn = max(count);

            if (list.get(i).get(0) == nn || list.get(i).get(1) == nn) {
                list.remove(i);
                sum++;
            }
            result.add(nn);
            i++;
        }
        System.out.println(sum);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }

    //输出最大值的索引
    private static int max(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = max < i ? i : max;
        }
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) {
                max = i;
                arr[i] = 0;
                break;
            }
        }
        return max;
    }
}

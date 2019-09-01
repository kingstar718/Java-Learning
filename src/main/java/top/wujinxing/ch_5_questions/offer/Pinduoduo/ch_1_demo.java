package top.wujinxing.ch_5_questions.offer.Pinduoduo;

import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/9/1 15:02
 * description
 * <p>
 * 偶数优先级大于奇数
 * 同种数 数值大的优先
 * <p>
 * 输入  数字,数字，。。。数字；参数N
 * <p>
 * 输出  N个满足题目条件的数
 */
public class ch_1_demo {

    //40%
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String[] sArr = s.split(",");
        String[] last = sArr[sArr.length - 1].split(";");
        sArr[sArr.length - 1] = last[0];
        int N = Integer.parseInt(last[1]);
        int[] arr = new int[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(N);*/
        int[] arr = {555503, 772867, 756893, 339138,
                399447, 40662, 859037, 628085, 855723, 974471,
                599631, 636153, 581541, 174761, 948135, 411485,
                554033, 858627, 402833, 546467, 574367, 360461,
                566480, 755523, 222921, 164287, 420256, 40043,
                977167, 543295, 944841, 917125, 331763, 188173,
                353275, 175757, 950417, 284578, 617621, 546561,
                913416, 258741, 260569, 630583, 252845};
        int N = 10;
        int[] result = {913416, 566480, 420256, 339138, 284578, 40662, 977167, 974471, 950417, 948135};
        func(arr, N);
    }

    private static void func(int[] arr, int N) {
        if (arr == null || arr.length <= 0 || N <= 0)
            System.out.println(0);
        int len = arr.length;
        int oSum = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (arr[i] % 2 == 0) {
                list1.add(arr[i]);
            } else {
                list2.add(arr[i]);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        if (list1.size() >= N) {
            Stack<Integer> stack = new Stack<>();
            for (int i = list1.size() - 1; i >= 0; i--) {
                stack.push(list1.get(i));
            }
            for (int i = 0; i < N; i++) {
                System.out.print(stack.pop());
                if (i != N - 1)
                    System.out.print(",");
            }
        } else {
            for (int i = list1.size() - 1; i >= 0; i--) {
                System.out.print(list1.get(i) + ",");
            }
            for (int i = list2.size() - 1; i >= list2.size() - (N - list1.size()); i--) {
                System.out.print(list2.get(i));
                if (i != list2.size() - (N - list1.size()))
                    System.out.print(",");
            }
        }
    }
}

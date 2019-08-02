package top.wujinxing.ch_5_questions.offer.Netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ author: wujinxing
 * @ date: 2019/4/23 14:55
 * @ description:
 *
 * 题目描述
 * 小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,
 * 并且他要求学生按照身高不递减的顺序排列。
 * 有一次,n个学生在列队的时候,小易老师正好去卫生间了。
 * 学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,
 * 他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。
 * 由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。
 * 现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。
 * 小易老师回来一定会气得半死。
 *
 * 输入描述:
 * 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
 * 第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高
 * 输出描述:
 * 输出一个整数,表示n个学生列队可以获得的最大的疯狂值。
 *
 * 如样例所示:
 * 当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为15+30+35+20=100。
 * 这是最大的疯狂值了。
 * 示例1
 * 输入
 * 5
 * 5 10 25 40 25
 * 输出
 * 100
 */
public class CrazyQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i=0; i<n; i++){
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            int min = nums[0];  //上一次加入疯狂队列的那个最小值
            int max = nums[n-1];    //上一次加入疯狂队列的那个最大值
            int diff = max-min;
            int minIndex = 1;    //未加入疯狂队列的最小值索引
            int maxIndex = n-2;    //未加入疯狂队列的最大值索引
            //整体思路就是先去最大值和最小值, 然后将次大放在最小值旁, 次小放在最大值旁, 依次计算
            while (minIndex<maxIndex){
                diff += max-nums[minIndex];
                diff += nums[maxIndex]-min;
                min = nums[minIndex++];
                max = nums[maxIndex--];
            }
            // 原数列中最后一个数 minIndex == maxIndex，将它放到合适的位置上
            //暂不确定是放在最右还是最左, 取最大值即可
            diff += Math.max(nums[maxIndex]-min, max-nums[minIndex]);
            System.out.println(diff);
        }
    }
}

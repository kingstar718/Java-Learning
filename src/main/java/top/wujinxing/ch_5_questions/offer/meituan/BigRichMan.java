package top.wujinxing.ch_5_questions.offer.meituan;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/8/7 18:52
 * description  未完成
 *
 * 大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，
 * 点数为2时可以走两步，点数为n时可以走n步。求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，
 * 总共有多少种投骰子的方法。
 *
 * 输入描述:
 * 输入包括一个整数n,(1 ≤ n ≤ 6)
 * 输出描述:
 * 输出一个整数,表示投骰子的方法
 *
 * 输入例子1: 6
 * 输出例子1: 32
 *
 * 思路1:题目中的n<=6 很重要 ，如果实在不会可以手算出每个值,然后用switch,ac了这道题（看到别人写的，才发现有些条件的重要性）
 *
 * 思路2：玩家走到第n步时（并不代表走了n次），总共有多少中投骰子的方法，就是说玩家有多少中投的办法可以走到n步处。
 *
 * 递归思路：到了n步处 由前一次到达的位置+投掷一次
 * 玩家走了n步f（n），则可能性有：1、到n-1步f（n-1）+ 最后投了一个1
 * 2、到n-2步f（n-2）时投了一个2
 * .。。。。。
 *
 * n-1、到1步f（1）直接投了一个n-1
 * n、直接投出一个n
 * 故：f（n）=f（n-1）+f（n-2）+......+f（1）+1；
 */
public class BigRichMan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(fun(num));
    }

    private static int fun(int num) {
        if (num == 1){
            return 1;
        }else {
            int sum = 0;
            for(int i=1; i<num; i++){
                sum += fun(i);
            }
            sum += 1;
            return sum;
        }
    }
}

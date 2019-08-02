package top.wujinxing.ch_5_questions.offer.Netease;

import java.util.Scanner;

/**
 * @ author: wujinxing
 * @ date: 2019/4/22 14:19
 * @ description: 独立生活
 *
 * 小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。
 * 一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。
 * 当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。
 * 小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
 * 输入描述:
 * 输入包括一行,四个整数x, f, d, p(1 ≤ x,f,d,p ≤ 2 * 10^9),以空格分割
 * 输出描述:
 * 输出一个整数, 表示小易最多能独立生活多少天。
 * 示例1
 * 输入
 * 3 5 100 10
 * 输出
 * 11
 */
public class lifeTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt();//每天x元, 房屋租金
        long f = sc.nextInt();//手里有f个苹果
        long d = sc.nextInt();//手里有d元钱
        long p = sc.nextInt();//每个苹果买=卖p元
        lifeTimeTest(x, f, d, p);
    }

    public static void lifeTimeTest(long x, long f, long d, long p){
        long n;
        if (x*f >= d){//当不买苹果,全吃已有的苹果, 全花费到租金上
            n = d/x;//能生活d/x天
        }else {//房屋租金小于手里的钱
            n = (d+f*p)/(x+p);
        }
        System.out.println(n);
    }

}

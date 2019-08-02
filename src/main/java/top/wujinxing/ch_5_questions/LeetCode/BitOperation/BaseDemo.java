package top.wujinxing.ch_5_questions.LeetCode.BitOperation;

/**
 * @author wujinxing
 * date 2019/4/28 14:56
 * description
 */
public class BaseDemo {
    public static void main(String[] args) {
        //进制转化
        int n = 6;
        int n2 = -6;
        //110
        System.out.println(Integer.toBinaryString(n));
        //11111111111111111111111111111010
        //先反码 接着+1 所有数值均用补码表示
        System.out.println(Integer.toBinaryString(n2));
        //System.out.println(Integer.toString(n, 5)); //转任意进制

        //1&1=1, 1&0=0, 0^1=0, 0&0=0
        int i = 3&5, y = 5&7;
        System.out.println("&运算结果: 3&5 = " + i + ",  5&7结果" + y);

        //1|1=1, 1|0=1, 0|1=1, 0|0=0
        int x = 6|2;
        System.out.println("| 运算结果: " + x);

        //1^1=0, 1^0=1, 0^1=1, 0^0=1
        int m = 5^9;
        System.out.println("^ 运算结果: " + m);

        //~取反  二进制操作
        System.out.println("5的取反~的值为: " + ~5);
    }
}

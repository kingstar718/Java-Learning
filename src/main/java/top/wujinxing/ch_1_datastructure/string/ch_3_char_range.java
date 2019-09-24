package top.wujinxing.ch_1_datastructure.string;

import java.util.Random;

/**
 * @author wujinxing
 * date 2019/9/24 13:13
 * description ASCII 字符集
 */
public class ch_3_char_range {

    public static void main(String[] args) {
        char a = '\u0061'; //向 char 类型的 a 变量赋值为 A，所对应的 ASCII 值为 65
        char b = 'B';    // 向 char 类型的 b 变量赋值为 B，所对应的 ASCII 值为 66
        System.out.println("A 的 ASCII 值与 B 的 ASCII 值相加结果为：" + (a + b));
        char z = '\u007A';
        char A = '\u0041';
        char Z = '\u005A';
        int aNum = a; //直接是十进制的数值，表示ASCII中该字符的位置
        System.out.println(a + " " + A); // a A
        System.out.println(z + " " + Z); // z Z
        System.out.println(aNum); //97

        int bin = 0B11; // 0B 0b 后加数字是二进制
        int eight = 011;  // 0 后加数字是八进制
        int sixteen = 0X12; // 0X 0x 后加数字是十六进制
        System.out.println(bin); //3
        System.out.println(eight); //9
        System.out.println(sixteen); //18

        char c1 = 'a';
        char c2 = '\n'; //换行
        char c3 = '\u0061';
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println(new Random().nextInt(2));
    }
}

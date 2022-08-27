package top.wujinxing.ch_1_datastructure.string;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * ASCII 字符集
 *
 * @author wujinxing
 * @date 2019/9/24 13:13
 */
@Slf4j
public class CharRange {

    public static void main(String[] args) {
        //向 char 类型的 a 变量赋值为 A，所对应的 ASCII 值为 65
        char a = '\u0061';
        // 向 char 类型的 b 变量赋值为 B，所对应的 ASCII 值为 66
        char b = 'B';
        log.info("A 的 ASCII 值与 B 的 ASCII 值相加结果为：{}", (a + b));

        char z = '\u007A';
        char A = '\u0041';
        char Z = '\u005A';
        //直接是十进制的数值，表示ASCII中该字符的位置
        int aNum = a;
        log.info(a + " " + A);
        log.info(z + " " + Z);
        log.info("aNum: {}", aNum);

        // 0B 0b 后加数字是二进制
        int bin = 0B11;
        // 0 后加数字是八进制
        int eight = 011;
        // 0X 0x 后加数字是十六进制
        int sixteen = 0X12;
        log.info("二进制 bin: {}", bin);
        log.info("八进制 bin: {}", eight);
        log.info("十六进制 bin: {}", sixteen);

        char c1 = 'a';
        //换行
        char c2 = '\n';
        char c3 = '\u0061';
        log.info("c1: {}", c1);
        log.info("c2: {}", c2);
        log.info("c3: {}", c3);

        log.info("random: {}", new Random().nextInt(2));
    }
}

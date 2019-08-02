package top.wujinxing.ch_3_algorithm.keyboardinput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: wujinxing
 * @date: 2019/3/29 14:37
 * @description:
 */
public class example2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入: ");
        String s = input.readLine();
        System.out.println("s = " + s);
    }
}

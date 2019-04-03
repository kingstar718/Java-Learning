package top.wujinxing.keyboardinput;

import java.util.Scanner;

/**
 * @author: wujinxing
 * @date: 2019/3/29 14:33
 * @description:
 */
public class example1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入:");
        String s = input.nextLine();
        System.out.println("输入的内容为: " + s);
        input.close();
    }
}

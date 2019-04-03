package top.wujinxing;

import java.util.Scanner;

/**
 * @author: wujinxing
 * @date: 2019/1/2 20:55
 * @description:
 */
public class ch03number {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();

        try {
            int i = Integer.parseInt(userInput);
            System.out.println("The number ebtered: " + i);
        }catch (NumberFormatException e){
            System.out.println("Invalid user input");   //无效的
        }
    }
}

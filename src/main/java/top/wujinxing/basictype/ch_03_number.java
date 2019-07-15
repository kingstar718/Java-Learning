package top.wujinxing.basictype;
import java.util.Scanner;

/**
 * @author wujinxing
 * date: 2019/1/2 20:55
 * description:  输入与类型判断
 */
public class ch_03_number {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();

        try {
            int i = Integer.parseInt(userInput); //类型判断
            System.out.println("The number entered: " + i);
        }catch (NumberFormatException e){
            System.out.println("Invalid user input");   //无效的
        }
    }
}

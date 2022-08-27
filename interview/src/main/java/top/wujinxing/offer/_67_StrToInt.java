package top.wujinxing.offer;

import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/7/1 16:37
 * description 将字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * +2147483647
 *     1a33
 * 输出
 * 2147483647
 *     0
 */
public class _67_StrToInt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入：");
        String s = sc.nextLine();
        System.out.println(StrToInt(s));
    }

    public static int StrToInt(String str){
        if (str==null || str.length()==0) return 0;
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if (i==0 && (c=='+'||c=='-')) continue; //符号判定
            if (c<'0' || c>'9') return 0;   //非法输入
            ret = ret*10+(c-'0');
        }
        return isNegative? -ret: ret;

    }
}

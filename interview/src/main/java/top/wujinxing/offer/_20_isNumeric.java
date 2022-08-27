package top.wujinxing.offer;

/**
 * @author wujinxing
 * date 2019 2019/7/1 21:27
 * description 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例
 * 如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 使用正则表达式进行匹配
 * [] ： 字符集合
 * () ： 分组
 * ? ： 重复 0 ~ 1
 * + ： 重复 1 ~ n
 * * ： 重复 0 ~ n
 * . ： 任意字符
 * \\. ： 转义后的 .
 * \\d ： 数字
 */
public class _20_isNumeric {
    public static void main(String[] args) {
        String s1 = "+100";
        String s2 = "5e2";
        String s3 = "-1E-16";
        String s4 = "12e";
        String s5 = "1.2.3";
        String s6 = "12e+4.3";
        System.out.println(isNumeric(s1.toCharArray())+" " + isNumeric2(s1.toCharArray()));
        System.out.println(isNumeric(s2.toCharArray())+" " + isNumeric2(s2.toCharArray()));
        System.out.println(isNumeric(s3.toCharArray())+" " + isNumeric2(s3.toCharArray()));
        System.out.println(isNumeric(s4.toCharArray())+" " + isNumeric2(s4.toCharArray()));
        System.out.println(isNumeric(s5.toCharArray())+" " + isNumeric2(s5.toCharArray()));
        System.out.println(isNumeric(s6.toCharArray())+" " + isNumeric2(s6.toCharArray()));
    }

    public static boolean isNumeric(char[] str){
        if (str==null || str.length==0) return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
    public static boolean isNumeric2(char[] str){
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
}

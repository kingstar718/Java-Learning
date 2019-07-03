package top.wujinxing.basictype;

/**
 * @author wujinxing
 * date 2019 2019/7/3 17:17
 * description  数据类型的转换
 */
public class demo3 {
    public static void main(String[] args) {
        //字符串如何转基本数据类型
        String s = "111"; //"sss"无法使用下面的方法， 即字符串内需要是数字
        System.out.println(Integer.parseInt(s));
        System.out.println(Integer.valueOf(s));


        int n =10;
        String m = String.valueOf(n);
        System.out.println(m.getClass());

        //基本类型如何转字符串
        int c = 111;
        String c1 = c+"";
        System.out.println(c1.getClass());
    }
}

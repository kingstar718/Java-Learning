package top.wujinxing.ch_1_datastructure.string;

/**
 * @author wujinxing
 * date 2019 2019/7/3 10:49
 * description String中的+
 */
public class demo1 {
    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println(s1.hashCode());
        s1 = s1+" world";   //此时的s1已经不是原来new的对象了，而是另一个新建的对象了, 即s1指向了新建的String对象
        System.out.println(s1.hashCode());
        String s2 = "hello world";  //当String的值与s1相同时， s1、s2指向了同一个对象
        System.out.println(s2.hashCode());

        StringBuffer sb = new StringBuffer("hello"); //StringBuffer是多线程环境
        System.out.println(sb.hashCode());
        sb = sb.append(" world");   //原对象
        System.out.println(sb.hashCode());
    }
}

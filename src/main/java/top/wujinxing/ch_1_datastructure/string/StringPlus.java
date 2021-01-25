package top.wujinxing.ch_1_datastructure.string;

/**
 * @author wujinxing
 * date 2019 2019/7/3 10:49
 * description String中的+
 */
public class StringPlus {
    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println(s1.hashCode());
        //此时的s1已经不是原来new的对象了，而是另一个新建的对象了, 即s1指向了新建的String对象
        s1 = s1+" world";
        System.out.println(s1.hashCode());
        //当String的值与s1相同时， s1、s2指向了同一个对象
        String s2 = "hello world";
        System.out.println(s2.hashCode());

        //StringBuffer是多线程环境
        StringBuffer sb = new StringBuffer("hello");
        System.out.println(sb.hashCode());
        //原对象
        sb = sb.append(" world");
        System.out.println(sb.hashCode());
    }
}

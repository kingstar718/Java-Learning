package top.wujinxing.string;

import lombok.extern.slf4j.Slf4j;

/**
 * String中的+
 *
 * @author wujinxing
 * @date 2019 2019/7/3 10:49
 */
@Slf4j
public class StringPlus {

    public static void main(String[] args) {
        String s1 = "hello";
        log.info("s1.hashCode(): {}", s1.hashCode());

        //此时的s1已经不是原来new的对象了，而是另一个新建的对象了, 即s1指向了新建的String对象
        s1 = s1 + " world";
        log.info("s1 + world .hashCode(): {}", s1.hashCode());

        //当String的值与s1相同时， s1、s2指向了同一个对象
        String s2 = "hello world";
        log.info("s2.hashCode(): {}", s2.hashCode());

        //StringBuffer是多线程环境
        StringBuffer sb = new StringBuffer("hello");
        log.info("sb: {}", sb.hashCode());

        //原对象
        sb = sb.append(" world");
        log.info("sb.append(' world'): {}", sb.hashCode());

    }

}

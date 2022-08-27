package top.wujinxing.basictype;

import org.junit.Test;

/**
 * @author wujinxing
 * date: 2019/1/2 19:53
 * description:装箱与拆箱
 */
public class ch_07_IntAndInteger {

    @Test
    public void test() {
        int a = 1;
        int b = a;
        Integer m = new Integer(1);
        Integer c = new Integer(1);
        c = m;
        m = 2;
        a = 2;
        //c = 2;
        System.out.println(b);
        System.out.println(c);
    }
}

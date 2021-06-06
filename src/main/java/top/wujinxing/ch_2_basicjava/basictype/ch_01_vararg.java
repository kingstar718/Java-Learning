package top.wujinxing.ch_2_basicjava.basictype;

import org.junit.Test;

/**
 * @author wujinxing
 * date: 2019/1/2 20:10
 * description:
 */
public class ch_01_vararg {
    /**
     * @param args 允许不传递参数或者传递任意数量的String参数
     */
    private static void vararg1(String... args) {
        System.out.println("vararg1 String ...args参数传递方式");
        for (String arg : args) {
            System.out.print(arg + " ");
        }
    }

    /**
     * @param args * 传递string数组或者null
     */
    private static void vararg2(String[] args) {
        System.out.println("vararg2 String[]参数传递方式：");
        for (String arg : args) {
            System.out.print(arg + " ");
        }

    }

    @Test
    public void test() {
        vararg1("aaa", "bbb", "");
        String[] a = {"aaa", "bbb", ""};
        vararg2(a);
    }
}

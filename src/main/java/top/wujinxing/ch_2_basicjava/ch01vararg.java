package top.wujinxing.ch_2_basicjava;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/1/2 20:10
 * @description:
 */
public class ch01vararg {
    /**
     * 允许不传递参数或者传递任意数量的String参数
     * @param args
     */
    public static void vararg1(String... args){
        for(String arg : args){
            System.out.println(arg);
        }
        System.out.println("vararg1");
    }

    /**
     * 传递string数组或者null
     * @param args
     */
    public static void vararg2(String[] args){
        for(String arg : args){
            System.out.println(arg);
        }
        System.out.println("vararg2");
    }

    @Test
    public void test(){
        vararg1("aaa","bbb","");
        String[] a = {"aaa","bbb",""};
        vararg2(a);
    }
}

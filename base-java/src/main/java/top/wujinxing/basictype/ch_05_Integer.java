package top.wujinxing.basictype;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/7/3 16:10
 * description 基本数据类型例子
 */
public class ch_05_Integer {

    public static void main(String[] args) {
        //隐含的类型强制转换
        short s1 = 1;
        //s1 = s1+1; //错误
        s1 += 1;  //相当于s1=(short)(s1+1); 隐含了强制类型转换

        //包装类的自动装箱与拆箱
        Integer i1 = new Integer(3);
        Integer i2 = 3;     //将3自动装箱成Integer类型
        int c = 3;
        System.out.println(i1 == i2);  //false 两个引用没有引用同一对象
        System.out.println(i1 == c);      //true  自动拆箱成int类型再和c比较

        //整型字面量的值在-128 到 127 之间，那么不会 new 新的 Integer 对象，而是直接引用常量池中的 Integer 对象，
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2); //true
        System.out.println(f3 == f4);//false


    }

    @Test
    public void test1() {
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        Assert.assertFalse(i == j);
        Assert.assertFalse(i < j);
        Assert.assertFalse(i > j);
    }

    @Test
    public void test2() {
        Integer i = 100;
        Integer j = 100;
        Assert.assertSame(i, j);
        Assert.assertFalse(i < j);
        Assert.assertFalse(i > j);
    }

}

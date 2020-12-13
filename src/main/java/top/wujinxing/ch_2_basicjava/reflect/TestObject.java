package top.wujinxing.ch_2_basicjava.reflect;

/**
 * @author wujinxing
 * @date 2020/12/13
 */
public class TestObject {

    public static String name = "TestObject";

    static {
        System.out.println("static field");
    }

    public TestObject() {
        System.out.println("TestObject constructor");
    }
}

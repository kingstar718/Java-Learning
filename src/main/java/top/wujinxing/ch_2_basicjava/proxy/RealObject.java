package top.wujinxing.ch_2_basicjava.proxy;

/**
 * @author wujinxing
 * date 2019 2019/5/13 10:18
 * description
 */
public class RealObject implements InterfaceDemo {
    @Override
    public void doSomething() {
        System.out.println("doSomething...");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

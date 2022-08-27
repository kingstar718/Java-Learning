package top.wujinxing.delegate;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:16
 * description 2.创建两个员工类ATarget和BTarget
 */
public class ATarget implements Target {

    @Override
    public void doSomething(String commond) {
        System.out.println("A员工做具体的事情："+commond + "");
    }
}

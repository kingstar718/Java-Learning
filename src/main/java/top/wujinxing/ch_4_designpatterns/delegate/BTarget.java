package top.wujinxing.ch_4_designpatterns.delegate;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:16
 * description 2.创建两个员工类ATarget和BTarget
 */
public class BTarget implements Target{
    @Override
    public void doSomething(String commond) {
        System.out.println("B员工做具体的事情："+commond);
    }
}

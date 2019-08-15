package top.wujinxing.ch_4_designpatterns.delegate;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:25
 * description 4.接下来就是大boss上场，但是大boss不会去直接给做事的员工下达命令，
 *              而是给leader直接下达命令,比如下达一个打印文件的工作。
 */
public class DelegateTest {
    public static void main(String[] args) {
        new Leader().doSomething("打印文件");
    }
}

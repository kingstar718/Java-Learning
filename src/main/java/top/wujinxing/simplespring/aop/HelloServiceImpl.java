package top.wujinxing.simplespring.aop;

/**
 * @author: wujinxing
 * @date: 2019/4/3 17:16
 * @description:
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHelloWorld() {
        System.out.println("hello world");
    }
}

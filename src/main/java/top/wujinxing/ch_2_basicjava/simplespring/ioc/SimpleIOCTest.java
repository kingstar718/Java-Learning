package top.wujinxing.ch_2_basicjava.simplespring.ioc;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/4/2 22:23
 * @description:
 */
public class SimpleIOCTest {

    @Test
    public void getBean() throws Exception{

        //原句有问题
        String location = SimpleIOC.class.getClassLoader().getResource("D:\\Git\\JavaReview\\ch-1\\src\\main\\java\\top\\wujinxing\\simplespring\\ioc\\ioc.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);


    }

    @Test
    public void IOCtest() throws Exception{
        SimpleIOC simpleIOC = new SimpleIOC("D:\\Git\\Java-Learning\\src\\main\\java\\top\\wujinxing\\simplespring\\ioc\\ioc.xml");
        Wheel wheel = (Wheel) simpleIOC.getBean("wheel");
        System.out.println(wheel.toString());
        Car car = (Car) simpleIOC.getBean("car");
        System.out.println(car);
    }
}

package top.wujinxing.simplespring.ioc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Objects;

/**
 * @author wujinxing
 * @date 2019/4/2 22:23
 */
@Slf4j
public class SimpleIocTest {

    @Test
    public void getBean() throws Exception{

        String location = Objects.requireNonNull(SimpleIoc.class.getClassLoader().getResource("ioc.xml")).getFile();
        SimpleIoc bf = new SimpleIoc(location);

        Wheel wheel = (Wheel) bf.getBean("wheel");
        log.info("simple ioc get bean wheel: {}", wheel);

        Car car = (Car) bf.getBean("car");
        log.info("simple ioc get bean wheel: {}", car);

    }

}

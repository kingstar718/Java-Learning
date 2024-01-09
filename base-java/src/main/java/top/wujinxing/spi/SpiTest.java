package top.wujinxing.spi;

import top.wujinxing.spi.api.HelloSpi;

import java.util.ServiceLoader;

/**
 * @author wujinxing
 * @date 2024/1/9
 */
public class SpiTest {

    public static void main(String[] args) {
        ServiceLoader<HelloSpi> helloSpiList = ServiceLoader.load(HelloSpi.class);
        for (HelloSpi spi : helloSpiList) {
            spi.sayHello();
        }
    }

}

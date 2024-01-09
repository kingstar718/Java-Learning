package top.wujinxing.spi.impl;

import top.wujinxing.spi.api.HelloSpi;

/**
 * @author wujinxing
 * @date 2024/1/9
 */
public class ImageHello implements HelloSpi {
    @Override
    public void sayHello() {
        System.out.println("Image Hello!");
    }
}

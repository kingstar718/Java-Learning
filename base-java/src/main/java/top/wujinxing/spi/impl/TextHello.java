package top.wujinxing.spi.impl;

import top.wujinxing.spi.api.HelloSpi;

/**
 * @author wujinxing
 * @date 2024/1/9
 */
public class TextHello implements HelloSpi {
    @Override
    public void sayHello() {
        System.out.println("Text Hello!");
    }
}

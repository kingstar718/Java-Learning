package top.wujinxing.ch_4_designpatterns.FactoryMethod;

/**
 * @author: wujinxing
 * @date: 2019/4/9 15:57
 * @description:
 */
public class ConcreteFactory2 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}

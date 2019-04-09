package top.wujinxing.DesignPatterns.FactoryMethod;

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

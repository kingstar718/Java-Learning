package top.wujinxing.designpatterns.FactoryMethod;

/**
 * @author: wujinxing
 * @date: 2019/4/9 15:55
 * @description:
 */
public class ConcreteFactory1 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}

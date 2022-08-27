package top.wujinxing.FactoryMethod;

/**
 * @author: wujinxing
 * @date: 2019/4/9 15:52
 * @description:
 */
public class ConcreteFactory extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}

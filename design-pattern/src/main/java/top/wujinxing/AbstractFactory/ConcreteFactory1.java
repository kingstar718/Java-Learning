package top.wujinxing.AbstractFactory;

/**
 * @author: wujinxing
 * @date: 2019/4/9 16:41
 * @description:
 */
public class ConcreteFactory1 extends AbstractFactory {
    @Override
    AbstractProductA createtProductA() {
        return new ProductA1();
    }

    @Override
    AbstractProductB createtProductB() {
        return new ProductB1();
    }
}

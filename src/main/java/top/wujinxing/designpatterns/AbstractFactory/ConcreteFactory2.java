package top.wujinxing.designpatterns.AbstractFactory;

/**
 * @author: wujinxing
 * @date: 2019/4/9 16:41
 * @description:
 */
public class ConcreteFactory2 extends AbstractFactory {
    @Override
    AbstractProductA createtProductA() {
        return new ProductA2();
    }

    @Override
    AbstractProductB createtProductB() {
        return new ProductB2();
    }
}

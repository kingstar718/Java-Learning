package top.wujinxing.ch_4_designpatterns.AbstractFactory;

/**
 * @author: wujinxing
 * @date: 2019/4/9 16:42
 * @description:
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractFactory factory2 = new ConcreteFactory2();
        AbstractProductA productA1 = factory1.createtProductA();
        AbstractProductB productB1 = factory1.createtProductB();
        AbstractProductA productA2 = factory2.createtProductA();
        AbstractProductB productB2 = factory2.createtProductB();
    }
}

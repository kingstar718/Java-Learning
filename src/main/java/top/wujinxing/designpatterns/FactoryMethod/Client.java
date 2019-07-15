package top.wujinxing.designpatterns.FactoryMethod;

/**
 * @author: wujinxing
 * @date: 2019/4/9 15:59
 * @description: 与简单工厂的不同是由工厂的子类来创建对象
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactory();
        Factory factory1 = new ConcreteFactory1();
        Factory factory2 = new ConcreteFactory2();
        factory.doSomething();
        factory1.doSomething();
        factory2.doSomething();
    }
}

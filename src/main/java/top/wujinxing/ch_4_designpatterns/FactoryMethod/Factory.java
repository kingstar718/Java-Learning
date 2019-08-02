package top.wujinxing.ch_4_designpatterns.FactoryMethod;

/**
 * @author: wujinxing
 * @date: 2019/4/9 15:49
 * @description:
 */
public abstract class Factory {
    abstract public Product factoryMethod();
    public void doSomething(){
        Product product = factoryMethod();
        //do something with product
    }
}

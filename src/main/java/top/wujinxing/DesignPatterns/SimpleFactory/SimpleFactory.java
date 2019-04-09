package top.wujinxing.DesignPatterns.SimpleFactory;

/**
 * @author: wujinxing
 * @date: 2019/4/9 15:34
 * @description: 工厂类
 */
public class SimpleFactory {

    public Product createProduct(int type){
        if (type == 1){
            return new ConcreteProduct1();
        }else if (type == 2){
            return new ConcreteProduct2();
        }else {
            return new ConcreteProduct();
        }
    }
}

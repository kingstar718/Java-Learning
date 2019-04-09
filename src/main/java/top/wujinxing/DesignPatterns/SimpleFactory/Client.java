package top.wujinxing.DesignPatterns.SimpleFactory;

/**
 * @author: wujinxing
 * @date: 2019/4/9 15:35
 * @description: 客户端根据需要创建相应的实例
 */
public class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        for (int i = 0; i < 3; i++){
            simpleFactory.createProduct(i);
        }
    }
}

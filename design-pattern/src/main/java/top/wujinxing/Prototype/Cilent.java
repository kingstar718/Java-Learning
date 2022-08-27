package top.wujinxing.Prototype;

/**
 * @author: wujinxing
 * @date: 2019/4/9 20:42
 * @description:
 * 使用原型实例指定要创建对象的类型，通过复制这个原型来创建新对象
 */
public class Cilent {
    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype("abc");
        Prototype clone = prototype.myClone();
        System.out.println(clone.toString());
    }
}

package top.wujinxing.ch_2_basicjava.reflect;

/**
 * 类加载器首先会检查这个类的Class对象是否已被加载过，
 * 如果尚未加载，默认的类加载器就会根据类名查找对应的.class文件。
 * <p>
 * 想在运行时使用类型信息，必须获取对象(比如类Base对象)的Class对象的引用，
 * 使用功能Class.forName(“Base”)可以实现该目的，或者使用base.class。
 * 注意，有一点很有趣，使用功能”.class”来创建Class对象的引用时，不会自动初始化该Class对象，
 * 使用forName()会自动初始化该Class对象。为了使用类而做的准备工作一般有以下3个步骤：
 * <p>
 * 加载：由类加载器完成，找到对应的字节码，创建一个Class对象
 * 链接：验证类中的字节码，为静态域分配空间
 * 初始化：如果该类有超类，则对其初始化，执行静态初始化器和静态初始化块
 *
 * @author wujinxing
 * @date 2019/5/13
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //不会初始化静态块
        Class class1 = TestObject.class;
        System.out.println("---");
        //会初始化静态域
        String classPath = "top.wujinxing.ch_2_basicjava.reflect.TestObject";
        Class class2 = Class.forName(classPath);
    }
}

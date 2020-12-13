package top.wujinxing.ch_2_basicjava.reflect;

/**
 * Java的反射机制
 *
 * @author wujinxing
 * @date 2019/5/13
 * Java的反射机制
 */
public class ReflectDemo1 {
    //静态加载: 初始化实例对象属于静态加载
    //动态加载: Class.forName()

    public static void main(String[] args) {

        //每个类都会产生一个对应的Class对象，也就是保存在.class文件。
        //所有类都是在对其第一次使用时，动态加载到JVM的，
        //当程序创建一个对类的静态成员的引用时，就会加载这个类。
        //Class对象仅在需要的时候才会加载，static初始化是在类加载时进行的。


        // 静态域会被初始化
        System.out.println(TestObject.name);

        //构造方法会被初始化
        TestObject testObject = new TestObject();
    }
}
package top.wujinxing.ch_2_basicjava.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射：运行时类信息
 *
 * 如果不知道某个对象的确切类型，RTTI可以告诉你，
 * 但是有一个前提：这个类型在编译时必须已知，这样才能使用RTTI来识别它。
 * Class类与java.lang.reflect类库一起对反射进行了支持，该类库包含Field、Method和Constructor类，
 * 这些类的对象由JVM在启动时创建，用以表示未知类里对应的成员。
 * *使用Constructor创建新的对象，
 * *用get()和set()方法获取和修改类中与Field对象关联的字段，
 * *用invoke()方法调用与Method对象关联的方法。
 * 还可以调用getFields()、getMethods()和getConstructors()等方法，以返回表示字段、方法、以及构造器对象的数组，
 * 这样，对象信息可以在运行时被完全确定下来，而在编译时不需要知道关于类的任何事情。
 * <p>
 * 反射机制并没有什么神奇之处，当通过反射与一个未知类型的对象打交道时，JVM只是简单地检查这个对象，
 * 看它属于哪个特定的类。因此，那个类的.class对于JVM来说必须是可获取的，要么在本地机器上，要么从网络获取。
 * 所以对于RTTI和反射之间的真正区别只在于：
 * <p>
 * RTTI，编译器在编译时打开和检查.class文件
 * 反射，运行时打开和检查.class文件
 *
 * @author wujinxing
 * @since 2019/5/13
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Person person = new Person("Curry", 30);
        Class clazz = person.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
            //getReadMethod()方法调用类的get函数 可以通过getWriteMethod()方法来调用类的set方法
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(person);

            System.out.println(key + " : " + value);
        }

    }
}

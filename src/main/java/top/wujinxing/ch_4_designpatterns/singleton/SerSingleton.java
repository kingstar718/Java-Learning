package top.wujinxing.ch_4_designpatterns.singleton;

/**
 * @author: wujinxing
 * @date: 2019/3/23 22:41
 * @description: 一个可被串行化的单例
 */
public class SerSingleton implements java.io.Serializable{
    String name;

    private SerSingleton(){
        System.out.println("Singleton is create");
        name = "SerSingleton";
    }
    private static SerSingleton instance = new SerSingleton();
    public static SerSingleton getInstance(){
        return instance;
    }
    public static void createString(){
        System.out.println("createString in Singleton");
    }
    /*private Object readResolve(){   //阻止生成新的实例,总是返回当前对象
        return instance;
    }*/
}

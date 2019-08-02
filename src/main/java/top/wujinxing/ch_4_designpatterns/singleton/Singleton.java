package top.wujinxing.ch_4_designpatterns.singleton;

/**
 * @author: wujinxing
 * @date: 2019/3/23 22:18
 * @description: 单例模式
 * 懒汉式->线程不安全
 *
 *
 */
public class Singleton {
    private Singleton(){  //私有构造函数保证单例不会被在系统的其他代码内被实例化
        System.out.println("Singleton is create");  //创建单例的过程可能会比较慢
    }
    private static Singleton singleton = new Singleton();
    public static Singleton getInstance(){
        return singleton;
    }
    public static void createString(){
        System.out.println("createString in Singleton");//这是模拟单例类扮演其他角色
    }
}

package top.wujinxing.singleton;

/**
 * @author: wujinxing
 * @date: 2019/3/23 22:36
 * @description:
 * 单例模式使用内部类来维护单例的实例
 * 当StaticSingleton被加载时,其内部类不会被初始化,所以可以保证该类被载入JVM时,不会初始化单例类
 * 而当getInstance方式被调用时,才会加载SingletonHolder,从而初始化instance
 */
public class StaticSingleton {
    private StaticSingleton(){
        System.out.println("StaticSingleton is create");
    }
    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }
    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }
}

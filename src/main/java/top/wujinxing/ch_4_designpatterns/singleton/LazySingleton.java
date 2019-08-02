package top.wujinxing.ch_4_designpatterns.singleton;

/**
 * @author: wujinxing
 * @date: 2019/3/23 22:25
 * @description: 引入延迟加载机制
 */
public class LazySingleton {
    private LazySingleton(){
        System.out.println("LazySingleton is create"); //创建单例的过程肯会比较缓慢
    }
    //对静态成员变量instance初始值赋予null,确保系统启动时没有额外的负载
    private static LazySingleton instance = null;
    public static synchronized LazySingleton getInstance(){
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }
}

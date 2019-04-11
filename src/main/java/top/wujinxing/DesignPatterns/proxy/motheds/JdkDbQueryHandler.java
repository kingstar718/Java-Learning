package top.wujinxing.DesignPatterns.proxy.motheds;

import top.wujinxing.DesignPatterns.proxy.example.DBQuery;
import top.wujinxing.DesignPatterns.proxy.example.IDBQuery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: wujinxing
 * @date: 2019/3/25 09:15
 * @description: JDK的动态代理
 */
public class JdkDbQueryHandler implements InvocationHandler {

    IDBQuery real = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (real==null){
            real = new DBQuery();   //如果是第一次调用,则生成真实对象
        }
        return real.request();  //使用真实主题完成实际的操作
    }

    //生成一个实现了IDBQuery接口的代理类,代理类的内部逻辑由JdkDbQueryHandler决定'
    //生成代理类后,由newProxyInstance方法返回该代理类的一个实例
    public static IDBQuery createJdkProxy(){
        IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[] { IDBQuery.class },
                new JdkDbQueryHandler());
        return jdkProxy;
    }
}

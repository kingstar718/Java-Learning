package top.wujinxing.proxy.motheds;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import top.wujinxing.proxy.example.DBQuery;
import top.wujinxing.proxy.example.IDBQuery;

import java.lang.reflect.Method;

/**
 * @author: wujinxing
 * @date: 2019/3/25 09:24
 * @description: CGLIB的动态代理类使用
 */
public class CglibDbQueryInterceptor implements MethodInterceptor {
    IDBQuery real = null;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (real==null){
            real = new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createCglibProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibDbQueryInterceptor()); //指定切入器,定义代理逻辑类
        enhancer.setInterfaces(new Class[]{ IDBQuery.class});   //定义实现的接口
        IDBQuery cglibProxy = (IDBQuery) enhancer.create(); //生成代理类的实例
        return cglibProxy;
    }
}

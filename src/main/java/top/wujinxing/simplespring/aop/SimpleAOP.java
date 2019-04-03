package top.wujinxing.simplespring.aop;

import java.lang.reflect.Proxy;

/**
 * @author: wujinxing
 * @date: 2019/4/3 17:14
 * @description: 生成代理类
 */
public class SimpleAOP {

    public static Object getProxy(Object bean, Advice advice){
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),
                bean.getClass().getInterfaces(), advice);
    }
}

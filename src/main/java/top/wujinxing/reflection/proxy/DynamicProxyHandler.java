package top.wujinxing.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wujinxing
 * date 2019 2019/5/13 10:19
 * description
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxyed;

    public DynamicProxyHandler(Object proxyed){
        this.proxyed = proxyed;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理工作了...");
        return method.invoke(proxyed, args);

    }
}

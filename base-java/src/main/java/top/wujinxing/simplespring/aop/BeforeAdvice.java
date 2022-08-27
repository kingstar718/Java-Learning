package top.wujinxing.simplespring.aop;

import java.lang.reflect.Method;

/**
 * @author: wujinxing
 * @date: 2019/4/3 17:10
 * @description: 实现Adviec接口, 是一个前置通知
 */
public class BeforeAdvice implements Advice{
    private Object bean;
    //实现类包含了切面逻辑
    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation){
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //在目标方法执行前调用
        methodInvocation.invoke();
        return method.invoke(bean, args);
    }
}

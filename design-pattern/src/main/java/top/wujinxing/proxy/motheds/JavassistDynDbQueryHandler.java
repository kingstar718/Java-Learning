package top.wujinxing.proxy.motheds;


import javassist.*;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import top.wujinxing.proxy.example.DBQuery;
import top.wujinxing.proxy.example.IDBQuery;

import java.lang.reflect.Method;

/**
 * @author: wujinxing
 * @date: 2019/3/25 09:47
 * @description: Javassist 动态代理
 */
public class JavassistDynDbQueryHandler implements MethodHandler {
    IDBQuery real = null;

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        if (real==null){
            real = new DBQuery();
        }
        return real.request();
    }

    //使用代理工厂创建
    public static IDBQuery createJavassistDynProxy() throws Exception{
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(new Class[]{IDBQuery.class}); //指定接口
        Class proxyClass = proxyFactory.createClass();
        IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
        //设置Handler处理器
        ((ProxyObject) javassistProxy).setHandler(new JavassistDynDbQueryHandler());
        return javassistProxy;
    }

    //使用动态Java代码创建代理
    public static IDBQuery createJavassistBytecodeDynamicProxy() throws Exception{
        ClassPool mPool = new ClassPool(true);
        //定义类名
        CtClass mCtc = mPool.makeClass(IDBQuery.class.getName() + "JavassistBytecodeProxy");
        //需要实现的接口
        mCtc.addInterface(mPool.get(IDBQuery.class.getName()));
        //添加构造函数
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        //添加类的字段信息,使用动态Java代码   注意前后空格
        mCtc.addField(CtField.make("public " + IDBQuery.class.getName()+" real;",mCtc));
        String dbqueryname = DBQuery.class.getName();
        //添加方法,这里使用动态Java代码指定内部逻辑
        mCtc.addMethod(CtNewMethod.make(
                "public String request() { if(real==null) real=new " +
                        dbqueryname + "();return real.request(); }",mCtc
        ));
        //基于以上信息,生成动态类
        Class pc = mCtc.toClass();
        //生成动态类的实例
        IDBQuery bytecodeProxy = (IDBQuery) pc.newInstance();
        return bytecodeProxy;

        /**
         * 以上代码,使用CtField.make和CtNewMethod.make方法在运行时生成了代理类的字段和方法
         * 这些逻辑由Javassist的CtClass处理,将Java代码转换为对应的字节码,并生成动态代理的类的实例
         */
    }
}

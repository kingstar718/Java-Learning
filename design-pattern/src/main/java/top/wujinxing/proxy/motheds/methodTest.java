package top.wujinxing.proxy.motheds;

import top.wujinxing.proxy.example.IDBQuery;

/**
 * @author: wujinxing
 * @date: 2019/3/25 11:04
 * @description: 多种动态代理的性能测试
 */
public class methodTest {
    public static final int CIRCLE = 30000000;
    public static void main(String[] args) throws Exception{
        IDBQuery d = null;
        long begin = System.currentTimeMillis();
        d = JdkDbQueryHandler.createJdkProxy();     //Test the Jdk dynamic proxy
        System.out.println("createJdkProxy Time: " + (System.currentTimeMillis()-begin));
        System.out.println("JdkProxy class: " + d.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i=0; i<CIRCLE; i++){
            d.request();
        }
        System.out.println("callJdkProxy: " + (System.currentTimeMillis()-begin));

        begin = System.currentTimeMillis();
        d = CglibDbQueryInterceptor.createCglibProxy(); //Test the CGLIB dynamic proxy
        System.out.println("createCglibProxy Time: " + (System.currentTimeMillis()-begin));
        System.out.println("CglibProxy class: " + d.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i=0; i<CIRCLE; i++){
            d.request();
        }
        System.out.println("CallCglibProxy: " + (System.currentTimeMillis()-begin));

        begin = System.currentTimeMillis();
        d = JavassistDynDbQueryHandler.createJavassistDynProxy();   //Test the Javassist dynamic proxy
        System.out.println("createJavassistDynProxy Time: " + (System.currentTimeMillis()-begin));
        System.out.println("JavassistDynProxy class: " + d.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i=0; i<CIRCLE; i++){
            d.request();
        }
        System.out.println("CallJavassistDynProxy: " + (System.currentTimeMillis()-begin));

        begin = System.currentTimeMillis();
        d = JavassistDynDbQueryHandler.createJavassistBytecodeDynamicProxy();   //Test the Javassist dynamic proxy
        System.out.println("createJavassistBytecodeDynamicProxy Time: " + (System.currentTimeMillis()-begin));
        System.out.println("JavassistBytecodeDynamicProxy class: " + d.getClass().getName());
        begin = System.currentTimeMillis();
        for (int i=0; i<CIRCLE; i++){
            d.request();
        }
        System.out.println("CallJavassistBytecodeDynamicProxy: " + (System.currentTimeMillis()-begin));

    }

}

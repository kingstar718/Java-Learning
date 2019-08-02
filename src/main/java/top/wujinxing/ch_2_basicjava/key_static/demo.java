package top.wujinxing.ch_2_basicjava.key_static;

/**
 * @author: wujinxing
 * @date: 2019/2/23 14:29
 * @description:
 */
public class demo {
    public static void main(String[] args){
        B b = new B();
        //-A--static--A--B-
        //构造器与静态代码块执行，静态代码块只执行一次,构造器先执行
    }
}

class A{
    private static A a = new A();
    static {
        System.out.print("-static-");
    }
    public A(){
        System.out.print("-A-");
    }
}

class B extends A {
    public B(){
        System.out.print("-B-");
    }
}
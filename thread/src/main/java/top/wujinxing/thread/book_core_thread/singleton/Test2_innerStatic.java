package top.wujinxing.thread.book_core_thread.singleton;

/**
 * @author: wujinxing
 * @date: 2019/3/6 16:08
 * @description:    使用静态内置类实现单例模式
 */
public class Test2_innerStatic {
    public static void main(String[] args){
        MyThread2 t1 = new MyThread2();
        MyThread2 t2 = new MyThread2();
        MyThread2 t3 = new MyThread2();
        t1.start();
        t2.start();
        t3.start();
    }

}

class MyObject2{
    //静态内部类
    private static class MyObjectHandler{
        private static MyObject2 myObject2 = new MyObject2();
    }
    private MyObject2(){}
    public static MyObject2 getInstance(){
        return MyObjectHandler.myObject2;
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println(MyObject2.getInstance().hashCode());
    }
}
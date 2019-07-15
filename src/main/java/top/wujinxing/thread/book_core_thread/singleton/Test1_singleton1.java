package top.wujinxing.thread.book_core_thread.singleton;

/**
 * @author: wujinxing
 * @date: 2019/3/6 15:41
 * @description:    常见的延迟加载在多线程环境中不能保持单例的状态。
 */
public class Test1_singleton1 {
    public static void main(String[] args){
        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        MyThread1 t3 = new MyThread1();
        t1.start();
        t2.start();
        t3.start();
        //打印出3gehashCode，说明创建了三个对象，并不是单例的
    }
}

class MyObject1{
    private static MyObject1 myObject1;
    private MyObject1(){

    }
    public static MyObject1 getMyObject1(){
        try {
            if (myObject1 != null){

            }else {
                Thread.sleep(3000);
                myObject1 = new MyObject1();//此时才创建对象
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject1;
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println(MyObject1.getMyObject1().hashCode());
    }
}
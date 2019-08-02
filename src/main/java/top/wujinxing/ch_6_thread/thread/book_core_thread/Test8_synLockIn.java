package top.wujinxing.ch_6_thread.thread.book_core_thread;

/**
 * @author: wujinxing
 * @date: 2019/2/27 20:56
 * @description:    锁重入
 */
public class Test8_synLockIn {
    public static void main(String[] args){
        MyThread8 t = new MyThread8();
        t.start();
    }
}

class Service{
    synchronized public void service1(){
        System.out.println("service1");
        service2();
    }
    synchronized public void service2(){
        System.out.println("service2");
        service3();
    }
    synchronized public void service3(){
        System.out.println("service3");
    }
}

class MyThread8 extends Thread{
    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }
}
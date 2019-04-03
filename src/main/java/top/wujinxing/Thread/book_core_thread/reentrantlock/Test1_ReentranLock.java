package top.wujinxing.Thread.book_core_thread.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wujinxing
 * @date: 2019/3/5 14:10
 * @description:
 */
public class Test1_ReentranLock {
    public static void main(String[] args){
        MyService1 service = new MyService1();
        MyThread1 a1 = new MyThread1(service);
        MyThread1 a2 = new MyThread1(service);
        MyThread1 a3 = new MyThread1(service);
        MyThread1 a4 = new MyThread1(service);
        MyThread1 a5 = new MyThread1(service);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
        //线程类打印有序，启动哪个线程无序
    }


}

class MyService1 {
    private Lock lock = new ReentrantLock();

    //调用ReentrantLock对象的lock获取锁，unlock释放锁
    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 5; i++){
            System.out.println("ThreadName = " + Thread.currentThread().getName() + (" " + (i + 1)));
        }
        lock.unlock();
    }
}

class MyThread1 extends Thread{
    private MyService1 service;
    public MyThread1(MyService1 service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
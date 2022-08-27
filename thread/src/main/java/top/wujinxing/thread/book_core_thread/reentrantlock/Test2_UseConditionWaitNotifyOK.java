package top.wujinxing.thread.book_core_thread.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wujinxing
 * @date: 2019/3/5 14:29
 * @description:    Condition类中方法await与signal的使用
 */
public class Test2_UseConditionWaitNotifyOK {
    public static void main(String[] args) throws InterruptedException {
        MyService2 service = new MyService2();
        MyThread2 a = new MyThread2(service);
        a.start();
        Thread.sleep(3000);
        service.signal();
    }
}

class MyService2{
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public void await() {
        try {
            lock.lock();
            System.out.println(" await时间为" + System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void signal() {
        try {
            lock.lock();
            System.out.println("signal时间为" + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}

class MyThread2 extends Thread{
    private MyService2 service;
    public MyThread2(MyService2 service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.await();
    }
}
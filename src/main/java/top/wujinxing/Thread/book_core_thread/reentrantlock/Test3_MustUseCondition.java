package top.wujinxing.Thread.book_core_thread.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wujinxing
 * @date: 2019/3/5 14:39
 * @description:    使用Condition实现通知部分线程
 */
public class Test3_MustUseCondition {
    public static void main(String[] args) throws InterruptedException {
        MyService3 service = new MyService3();
        ThreadA3 a = new ThreadA3(service);
        a.setName("A");
        a.start();
        ThreadB3 b = new ThreadB3(service);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        service.signalAll_A();
        //只有A被唤醒
    }
}

class MyService3{
    //创建多个condition的使用方法
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();
    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA时间为" + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("  end awaitA时间为" + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB时间为" + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("  end awaitB时间为" + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("  signalAll_A时间为" + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("  signalAll_B时间为" + System.currentTimeMillis()
                    + " ThreadName=" + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

class ThreadA3 extends Thread{
    private MyService3 service;
    public ThreadA3(MyService3 service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.awaitA();
    }
}

class ThreadB3 extends Thread {
    private MyService3 service;
    public ThreadB3(MyService3 service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.awaitB();
    }
}

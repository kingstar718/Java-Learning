package top.wujinxing.Thread.book_core_thread.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wujinxing
 * @date: 2019/3/5 14:48
 * @description: 使用Condition实现一对一交替打印
 */
public class Test4_Condition_OneToOne {
    public static void main(String[] args) throws InterruptedException{
        MyService4 myService = new MyService4();
        MyThread4A a = new MyThread4A(myService);
        a.start();
        MyThread4B b = new MyThread4B(myService);
        b.start();
    }
}

class MyService4{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set(){
        try {
            lock.lock();
            while (hasValue == true){
                condition.await();
            }
            System.out.println("打印★★★");
            hasValue = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void get(){
        try {
            lock.lock();
            while (hasValue == false){
                condition.await();
            }
            System.out.println("打印☆☆☆");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class MyThread4A extends Thread {

    private MyService4 myService;

    public MyThread4A(MyService4 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.set();
        }
    }
}

class MyThread4B extends Thread {

    private MyService4 myService;

    public MyThread4B(MyService4 myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            myService.get();
        }
    }
}

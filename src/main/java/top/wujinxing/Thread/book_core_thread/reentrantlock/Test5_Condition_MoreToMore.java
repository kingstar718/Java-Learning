package top.wujinxing.Thread.book_core_thread.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wujinxing
 * @date: 2019/3/5 15:10
 * @description: 实现多对多打印
 */
public class Test5_Condition_MoreToMore {
    public static void main(String[] args){
        MyService5 myService = new MyService5();
        MyThread5A[] a = new MyThread5A[10];
        MyThread5B[] b = new MyThread5B[10];
        for (int i = 0; i < 10; i++){
            a[i] = new MyThread5A(myService);
            b[i] = new MyThread5B(myService);
            a[i].start();
            b[i].start();
        }
    }
}

class MyService5{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set(){
        try {
            lock.lock();
            while (hasValue == true){
                System.out.println("有可能★★★连续");
                condition.await();
            }
            System.out.println("打印★★★");
            hasValue = true;
            //condition.signal();   //会假死
            condition.signalAll();
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
                System.out.println("有可能☆☆☆连续");
                condition.await();
            }
            System.out.println("打印☆☆☆");
            hasValue = false;
            //condition.signal();   //会假死
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class MyThread5A extends Thread {

    private MyService5 myService;

    public MyThread5A(MyService5 myService) {
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

class MyThread5B extends Thread {

    private MyService5 myService;

    public MyThread5B(MyService5 myService) {
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
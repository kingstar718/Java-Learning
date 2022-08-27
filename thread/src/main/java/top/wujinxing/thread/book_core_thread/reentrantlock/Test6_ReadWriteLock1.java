package top.wujinxing.thread.book_core_thread.reentrantlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: wujinxing
 * @date: 2019/3/5 16:54
 * @description:
 */
public class Test6_ReadWriteLock1 {
    public static void main(String[] args){
        Service6 service = new Service6();
        Thread6A a = new Thread6A(service);
        a.setName("A");
        Thread6B b = new Thread6B(service);
        b.setName("B");
        a.start();
        b.start();
    }

}

class Service6 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read() {
        try {
            try {
                //读锁
                //lock.readLock().lock();
                //写锁    必须要等到释放，B才能在获得
                lock.writeLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName()
                        + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                //lock.readLock().unlock();
                lock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Thread6A extends Thread {
    private Service6 service;
    public Thread6A(Service6 service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.read();
    }
}

class Thread6B extends Thread {
    private Service6 service;
    public Thread6B(Service6 service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.read();
    }
}

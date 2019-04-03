package top.wujinxing.Thread.book_core_thread.reentrantlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: wujinxing
 * @date: 2019/3/5 17:08
 * @description:    读写互斥
 */
public class Test7_ReadWriteLock2 {
    public static void main(String[] args){
        Service7 service = new Service7();
        Thread7A a = new Thread7A(service);
        a.setName("A");
        a.start();
        Thread7B b = new Thread7B(service);
        b.setName("B");
        b.start();
    }
}

class Service7 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read() {
        try {
            try {
                //读锁
                lock.readLock().lock();
                //写锁    必须要等到释放，B才能在获得
                //lock.writeLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName()
                        + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lock.readLock().unlock();
                //lock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void write() {
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

class Thread7A extends Thread {
    private Service7 service;
    public Thread7A(Service7 service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.read();
    }
}

class Thread7B extends Thread {
    private Service7 service;
    public Thread7B(Service7 service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.write();
    }
}

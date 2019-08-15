package top.wujinxing.ch_6_thread.review;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wujinxing
 * date 2019 2019/8/15 14:14
 * description 线程安全的3种实现
 */
public class ThreadSafe {

    public static void main(String[] args) {
        SaleWindow1 s1 = new SaleWindow1(); //synchronized锁对象
        SaleWindow2 s2 = new SaleWindow2(); //synchronized锁方法
        SaleWindow3 s3 = new SaleWindow3(); // lock锁
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);
        t1.start();
        t2.start();
        t3.start();
    }

    static class SaleWindow1 implements Runnable{
        private int id = 10; //表示10张火车票

        @Override
        public void run() {
            for (int i=0; i<10; i++){
                synchronized (this){
                    if (id>0){
                        System.out.println(Thread.currentThread().getName()+"卖了编号为 " + id +" 的火车票");
                        id--;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class SaleWindow2 implements Runnable{
        private int id = 10; //表示10张火车票

        @Override
        public void run() {
            saleOne();
        }
        //锁住方法
        private synchronized void saleOne() {
            if (id > 0) {
                System.out.println(Thread.currentThread().getName() + "卖了编号为" + id + "的火车票");
                id--;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SaleWindow3 implements Runnable{

        private int id = 10;
        Lock lock = new ReentrantLock();

        @Override
        public void run() {
            for (int i=0; i<10; i++){
                if (id>0){
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "卖了编号为" + id + "的火车票");
                    id--;
                    lock.unlock();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            }
        }
    }
}

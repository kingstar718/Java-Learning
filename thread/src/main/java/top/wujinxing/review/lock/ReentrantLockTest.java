package top.wujinxing.review.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wujinxing
 * date 2019 2019/8/15 17:04
 * description Lock的使用
 */
public class ReentrantLockTest implements Runnable {

    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        Thread t1 = new Thread(reentrantLockTest);
        Thread t2 = new Thread(reentrantLockTest);
        Thread t3 = new Thread(reentrantLockTest);
        //Thread t4 = new Thread(reentrantLockTest);
        //Thread t5 = new Thread(reentrantLockTest);
        t1.start();
        t2.start();
        t3.start();
        //t4.start();
        //t5.start();

        //从运行结果可以看出，当一个线程运行完毕后才把锁释放，其他线程才能执行，其他线程的执行顺序是不确定的。
    }

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i=0; i<5; i++){
                Thread.sleep(1000);
                System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

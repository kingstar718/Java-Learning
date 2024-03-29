package top.wujinxing.thread.book_art_thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author wujinxing
 * date 2019 2019/5/22 16:20
 * description
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }
    static class Wait implements Runnable{
        @Override
        public void run() {
            //加锁, 拥有lock的Monitor
            synchronized (lock){
                //条件不满足的时候, 继续wait, 同时释放lock的锁
                while (flag){
                    try {
                        System.out.println(Thread.currentThread()+" flag is true. wait @ "+
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足时,完成工作
                System.out.println(Thread.currentThread()+" flag is false. running @ "+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
    static class Notify implements Runnable{
        @Override
        public void run() {
            //加锁, 拥有lock的Monitor
            synchronized (lock){
                //获取lock的锁, 然后进行通知, 通知时不会释放lock的锁
                //直到当前线程释放了lock以后, WaitThread才能才能从wait方法返回
                System.out.println(Thread.currentThread()+" hold lock notify. wait @ "+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
            }
            //再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock again. sleep @ "+
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
}

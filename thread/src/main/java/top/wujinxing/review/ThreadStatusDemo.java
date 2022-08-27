package top.wujinxing.review;

import org.junit.Test;

/**
 * @author wujinxing
 * date 2019 2019/8/15 16:34
 * description 线程状态详解
 */
public class ThreadStatusDemo {

    @Test
    public void testJoin() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am " + Thread.currentThread());
            }
        });
        t.start();
        t.join();
        System.out.println("I am " + Thread.currentThread());
        //注释掉t.join();
        //I am Thread[main,5,main]
        //I am Thread[Thread-0,5,main]

        //加t.join();
        //I am Thread[Thread-0,5,main]
        //I am Thread[main,5,main]
    }

    @Test
    public void testWait() throws InterruptedException {
        Object obj = new Object();
        //消费者
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (obj){
                        System.out.println("等待通知唤醒");
                        obj.wait();
                        System.out.println("已被唤醒");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am " + Thread.currentThread());
            }
        });

        //消费者
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    obj.notify();
                    System.out.println("前往唤醒");
                }
                System.out.println("I am " + Thread.currentThread());
            }
        });

        t1.start();
        Thread.sleep(2000);
        t2.start();
        t1.join();
        t2.join();
        System.out.println("I am " + Thread.currentThread());
    }

    @Test
    public void testYield() throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1线程开始让出cpu");
                Thread.yield();
                System.out.println("t1线程执行完成");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2线程开始让出cpu");
                Thread.yield();
                System.out.println("t2线程执行完成");
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("I am "+Thread.currentThread());
    }
}

package top.wujinxing.thread.book_core_thread.wait_and_notify;

/**
 * @author: wujinxing
 * @date: 2019/3/1 11:21
 * @description:
 */
public class Test2_notify {
    public static void main(String[] args){
        try{
            Object lock = new Object();
            MyThread2A t1 = new MyThread2A(lock);
            t1.start();
            Thread.sleep(3000);
            MyThread2B t2 = new MyThread2B(lock);
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //开始   wait time=1551411072661
        //开始   notify time=1551411075655
        //结束   notify time=1551411075655
        //结束   wait time=1551411075655
        //3秒后线程被notify通知唤醒
    }
}

class MyThread2A extends Thread{
    private Object lock;
    public MyThread2A(Object lock){
        super();
        this.lock = lock;
    }
    @Override
    public void run() {
        try {
            synchronized (lock){
                System.out.println("开始   wait time=" +
                    System.currentTimeMillis());
                lock.wait();
                System.out.println("结束   wait time=" +
                        System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2B extends Thread{
    private Object lock;
    public MyThread2B(Object lock){
        super();
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock){
            System.out.println("开始   notify time=" +
                    System.currentTimeMillis());
            lock.notify();
            System.out.println("结束   notify time=" +
                    System.currentTimeMillis());
            }

    }
}
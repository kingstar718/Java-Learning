package top.wujinxing.Thread.book_core_thread.wait_and_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/3/1 11:33
 * @description:    注意notify执行，并不是立即释放锁，需要执行完synchronized
 */
public class Test3_wait_notify_size5 {
    public static void main(String[] args){
        try {
            Object lock = new Object();
            Thread3A a = new Thread3A(lock);
            a.start();
            Thread.sleep(50);
            Thread3B b = new Thread3B(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //wait begin 1551413038099
        // 添加了 1 个元素！
        // 添加了 2 个元素！
        // 添加了 3 个元素！
        // 添加了 4 个元素！
        // 已发出通知!
        // 添加了 5 个元素！
        // 添加了 6 个元素！
        // 添加了 7 个元素！
        // 添加了 8 个元素！
        // 添加了 9 个元素！
        // 添加了 10 个元素！
        //wait end 1551413048154
        //运行流程：
        /**
         * a线程启动 获得lock对象的锁
         * 执行run中的System.out.println("wait begin " + System.currentTimeMillis());
         * wait，a线程等待，释放掉对象锁
         *b线程获得lock对象锁，累加到size==5时，使用notify并发出通知
         *使用notify时，不会立马释放锁，要等synchronized代码块执行完才释放
         *a线程得到lock的对象锁，继续执行剩下的
         */
    }

}

class MyList3{
    private static List list = new ArrayList();
    public static void add(){
        list.add("anyString");
    }
    public static int size(){
        return list.size();
    }
}

class Thread3A extends Thread{
    private Object lock;
    public Thread3A(Object lock){
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            synchronized (lock){
                if (MyList3.size() != 5){
                    System.out.println("wait begin " + System.currentTimeMillis());
                    System.out.println("wait即将执行，线程将进入等待状态");
                    lock.wait();
                    System.out.println("wait状态结束");
                    System.out.println("wait end " + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread3B extends Thread{
    private Object lock;
    public Thread3B(Object lock){
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            synchronized (lock){
                for (int i = 0; i < 10; i++){
                    MyList3.add();
                    if (MyList3.size() == 5){
                        System.out.println("即将进入notify状态");
                        lock.notify();
                        System.out.println(" 已发出通知! ");
                    }
                    System.out.println(" 添加了 " + (i + 1) + " 个元素！");
                    Thread3A.sleep(1000);
                }
                System.out.println("b线程的synchronized代码块即将执行完");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
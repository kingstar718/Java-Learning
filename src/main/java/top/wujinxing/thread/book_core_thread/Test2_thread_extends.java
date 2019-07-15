package top.wujinxing.thread.book_core_thread;

/**
 * @author: wujinxing
 * @date: 2019/2/27 15:54
 * @description: 线程的优先级具有继承性
 */
public class Test2_thread_extends {
    public static void main(String[] args){
        System.out.println("main thread begin priority= " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread begin priority= " + Thread.currentThread().getPriority());
        MyThread1 thread1 = new MyThread1();
        thread1.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1 run priority=" + this.getPriority());
        MyThread2 thread2 = new MyThread2();
        thread2.start();
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1 run priority=" + this.getPriority());
    }
}

package top.wujinxing.thread;

/**
 * @author wujinxing
 * date 2019/2/20 17:15
 * description 线程优先级
 * 线程默认优先级为5，如果不手动指定，那么线程优先级具有继承性，
 * 比如线程A启动线程B，那么线程B的优先级和线程A的优先级相同。
 */
public class ThreadTest8 {
    public static void main(String[] args){
        System.out.println("main thread begin, priority = " + Thread.currentThread().getPriority());
        System.out.println("main thread end, priority = " + Thread.currentThread().getPriority());
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1 run priority = " + this.getPriority());
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread2 run priority = " + this.getPriority());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}

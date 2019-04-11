package top.wujinxing.Thread;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/2/20 17:09
 * @description:
 */
public class ThreadTest7 {
    //isAlive()测试线程是否处于活动状态，只要线程启动且没有终止，方法返回的就是true
    public static void main(String[] args) throws InterruptedException {
        MyThread7 myThread = new MyThread7();
        System.out.println("begin == " + myThread.isAlive());
        myThread.start();
        Thread.sleep(100);
        System.out.println("end == " + myThread.isAlive());
    }
}
class MyThread7 extends Thread{
    @Override
    public void run() {
        System.out.println("run == " + this.isAlive());
    }
}
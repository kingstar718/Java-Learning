package top.wujinxing.Thread;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/2/20 17:09
 * @description:
 */
public class ThreadTest7 {
    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("run == " + this.isAlive());
        }
    }

    //isAlive()测试线程是否处于活动状态，只要线程启动且没有终止，方法返回的就是true
    @Test
    public void Test() throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println("begin == " + myThread.isAlive());
        myThread.start();
        Thread.sleep(100);
        System.out.println("end == " + myThread.isAlive());
    }
}

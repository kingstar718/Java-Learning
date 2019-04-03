package top.wujinxing.Thread;

import org.junit.Test;


/**
 * @author: wujinxing
 * @date: 2019/2/20 16:12
 * @description:
 */
public class ThreadTest5 {

    public class MyThread extends Thread{
        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++){
                    Thread.sleep((int) (Math.random()*1000));
                    System.out.println("run = " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //CPU执行哪个线程的代码具有不确定性
    @Test
    public void Test(){
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            for (int i = 0; i < 3; i++){
                Thread.sleep((int) (Math.random()*1000));
                System.out.println("run = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
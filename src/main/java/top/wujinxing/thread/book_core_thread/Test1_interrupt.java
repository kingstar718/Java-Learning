package top.wujinxing.thread.book_core_thread;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/2/27 15:27
 * @description:
 */
public class Test1_interrupt {
    public class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 100; i++){
                System.out.println("i = " + (i+1));
            }
        }
    }
    @Test
    public  void test(){
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2000);
            //interrupt()仅仅在当前线程中打了一个停止的标记，并非真正停止线程
            thread.interrupt();
            //thread.currentThread().interrupt();
            System.out.println("是否停止1？=" + Thread.interrupted());
            System.out.println("是否停止2？=" + Thread.interrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}


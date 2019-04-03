package top.wujinxing.Thread;

import org.junit.Test;

/**
 * @author: wujinxing
 * @date: 2019/2/21 16:44
 * @description: setDaemon
 */
public class ThreadTest10 {
    public class MyThread extends Thread{
        private int i = 0;

        @Override
        public void run() {
            try {
                while (true){
                    i++;
                    System.out.println("i = " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test(){
        try {
            MyThread myThread = new MyThread();
            myThread.setDaemon(true);   //将其设为守护线程  setDaemon(true)必须在线程start()之前
            myThread.start();
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("我离开thread对象再也不打印了，我停止了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

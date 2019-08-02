package top.wujinxing.ch_6_thread.thread;

/**
 * @ author: wujinxing
 * @ date: 2019/2/18 21:47
 * @ description: 多线程创建方式之一————继承Thread类
 */
public class ThreadTest1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++){
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        //(new ThreadTest1()).start();
        Thread thread = new ThreadTest1();
        System.out.println(thread.getName());
        thread.start();
    }
}

package top.wujinxing.thread;

/**
 * @author wujinxing
 *  date 2019/2/20 16:44
 *  description
 */
public class ThreadTest6 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * 调用start()方法的顺序不代表线程启动的顺序，线程启动顺序具有不确定性。
     * @param args
     */
    public static void main(String[] args){
        ThreadTest6 myThread1 = new ThreadTest6();
        ThreadTest6 myThread2 = new ThreadTest6();
        ThreadTest6 myThread3 = new ThreadTest6();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}

package top.wujinxing.thread;

/**
 * @author wujinxing
 * date 2019/2/20 15:31
 * description
 */
public class ThreadTest4 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+"正在运行...");
        }
    }

    public static void main(String[] args){
        ThreadTest4 threadTest4 = new ThreadTest4();
        Thread t = new Thread(threadTest4);
        t.start();
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+"正在运行...");
        }
    }
}

package top.wujinxing.ch_6_thread.thread;

/**
 * @author wujinxing
 * date: 2019/2/23 21:07
 * description:
 * 线程类的构造方法、静态块是被main线程调用的，
 * 而线程类的run()方法才是应用线程自己调用的。
 *
 */
public class ThreadTest11{
    public static void main(String[] args){
        Thread11 thread11 = new Thread11();
        thread11.start();
        //静态块的打印：main
        //构造方法的打印：main
        //run()方法的打印：thread-0
    }
}
class Thread11 extends Thread{
    static{
        System.out.println("静态块的打印：" + Thread.currentThread().getName());
    }
    Thread11(){
        System.out.println("构造方法的打印：" + Thread.currentThread().getName());
    }
    @Override
    public void run() {
        System.out.println("run()方法的打印：" + Thread.currentThread().getName());
    }
}
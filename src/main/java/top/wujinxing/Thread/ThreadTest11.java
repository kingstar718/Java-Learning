package top.wujinxing.Thread;

/**
 * @author: wujinxing
 * @date: 2019/2/23 21:07
 * @description:
 * 线程类的构造方法、静态块是被main线程调用的，
 * 而线程类的run()方法才是应用线程自己调用的。
 *
 */
public class ThreadTest11 extends Thread{
    static{
        System.out.println("静态块的打印：" + Thread.currentThread().getName());
    }
    public ThreadTest11(){
        System.out.println("构造方法的打印：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run()方法的打印：" + Thread.currentThread().getName());
    }

    public static void main(String[] args){
        ThreadTest11 threadTest11 = new ThreadTest11();
        threadTest11.start();
        //静态块的打印：main
        //构造方法的打印：main
        //run()方法的打印：Thread-0
    }
}

package top.wujinxing.ch_6_thread.thread;

/**
 * @author wujinxing
 * date 2019/2/23 21:25
 * description this.XXX()"和"thread.currentThread().XXX()"的区别
 *
 */
public class ThreadTest12 extends Thread {
    public ThreadTest12()
    {
        System.out.println("MyThread5----->Begin");
        System.out.println("thread.currentThread().getName()----->" +
                Thread.currentThread().getName());
        System.out.println("this.getName()----->" + this.getName());
        System.out.println("MyThread5----->end");
    }

    @Override
    public void run()
    {
        System.out.println("run----->Begin");
        System.out.println("thread.currentThread().getName()----->" +
                Thread.currentThread().getName());
        System.out.println("this.getName()----->" + this.getName());
        System.out.println("run----->end");
    }
    public static void main(String[] args){
        ThreadTest12 threadTest12 = new ThreadTest12();
        threadTest12.start();
        //MyThread5----->Begin
        //thread.currentThread().getName()----->main
        //this.getName()----->thread-0
        //MyThread5----->end
        //执行MyThread05构造方法是main，当前线程却是Thread-0

        //run----->Begin
        //thread.currentThread().getName()----->thread-0
        //this.getName()----->thread-0
        //run----->end
        //执行run()方法的Thread-0，当前线程也是Thread-0，说明run()方法就是被线程实例去执行的

        //当前执行的Thread未必就是Thread本身。
    }
}

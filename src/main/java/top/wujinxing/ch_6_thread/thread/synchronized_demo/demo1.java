package top.wujinxing.ch_6_thread.thread.synchronized_demo;

/**
 * @author wujinxing
 * date 2019 2019/6/18 10:10
 * description   实例对象锁就是用synchronized修饰实例对象中的实例方法，注意是实例方法不包括静态方法，
 */
public class demo1 {
    public static void main(String[] args) throws InterruptedException {
        AccountingSync instance = new AccountingSync();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance); //对同一对象进行加锁
        t1.start();
        t2.start();
        //join含义:当前线程A等待thread线程终止之后才能从thread.join()返回
        t1.join();
        t2.join();
        System.out.println("加synchronized的方法: " + AccountingSync.i+ ",  普通方法"+ AccountingSync.s); //s的值可能就不是200000了

        //不同对象加锁
        Thread t3 = new Thread(new AccountingSync());
        Thread t4 = new Thread(new AccountingSync()); //存在着两个不同的实例对象锁
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println("加synchronized的方法: " + AccountingSync.i+ ",  普通方法"+ AccountingSync.s); //i, s的值可能就不是400000了

        //解决这种困境的的方式是将synchronized作用于静态的increase方法，这样的话，对象锁就当前类对象
        //m的增值方法为静态方法
        System.out.println(AccountingSync.m); //m值始终为400000


    }

}

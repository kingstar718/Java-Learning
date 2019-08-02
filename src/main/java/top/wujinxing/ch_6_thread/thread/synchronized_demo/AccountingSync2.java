package top.wujinxing.ch_6_thread.thread.synchronized_demo;

/**
 * @author wujinxing
 * date 2019 2019/6/18 10:52
 * description synchronized同步代码块
 */
public class AccountingSync2 implements Runnable {

    static AccountingSync2 instance = new AccountingSync2();
    static int i = 0;
    static int m = 0;

    /**
     * 将synchronized作用于一个给定的实例对象instance，即当前实例对象就是锁对象，
     * 每次当线程进入synchronized包裹的代码块时就会要求当前线程持有instance实例对象锁，
     * 如果当前有其他线程正持有该对象锁，那么新到的线程就必须等待，这样也就保证了每次只有一个线程执行i++;
     */
    @Override
    public void run() {
        synchronized (instance){
            for (int j=0; j<100000; j++){
                i++;
            }
        }
        //还可以使用this对象(代表当前实例)或者当前类的class对象作为锁，
        synchronized (this){
            for(int j=0; j<100000; j++){
                m++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i+" "+m);
    }
}

package top.wujinxing.review;

/**
 * @author wujinxing
 * date 2019 2019/8/15 14:07
 * description Runnable的使用
 */
public class RunnableDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableFor1());
        t1.setName("线程1");
        Thread t2 = new Thread(new RunnableFor2());
        t2.setName("线程2");
        t1.start();
        t2.start();
    }

    static class RunnableFor1 implements Runnable{
        @Override
        public void run() {
            for (int i=0; i<50; i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
    static class RunnableFor2 implements Runnable{
        @Override
        public void run() {
            for (int i=51; i<100; i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

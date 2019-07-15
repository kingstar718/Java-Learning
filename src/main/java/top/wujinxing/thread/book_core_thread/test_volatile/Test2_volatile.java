package top.wujinxing.thread.book_core_thread.test_volatile;

/**
 * @author: wujinxing
 * @date: 2019/2/28 16:39
 * @description: volatile增加了实例变量在多个线程之间的可见性，不具备同步性，那么也不具备原子性。
 */
public class Test2_volatile {
    public static void main(String[] args){
        /*MyThread2[] myThreadArray = new MyThread2[100];
        for (int i= 0; i < 100; i++){
            myThreadArray[i] = new MyThread2();
        }
        for (int i = 0; i < 100; i++){
            myThreadArray[i].start();
        }
        //运行的结果值不是10000
        */

        //结果为10000
        MyThread2B[] myThreadArray = new MyThread2B[100];
        for (int i= 0; i < 100; i++){
            myThreadArray[i] = new MyThread2B();
        }
        for (int i = 0; i < 100; i++){
            myThreadArray[i].start();
        }
    }
}

class MyThread2 extends Thread{
    volatile public static int count;
    private static void addCount(){
        for (int i = 0; i < 100; i++){
            count++;
        }
        System.out.println("count = " + count);
    }
    @Override
    public void run() {
        addCount();
    }
}

class MyThread2B extends Thread{
    public static int count;
    //注意一定要添加static关键字
    //这样synchronized与static锁的内容就是MyThread.class类了
    //也就达到同步效果l了
    synchronized private static void addCount(){
        for (int i = 0; i < 100; i++){
            count++;
        }
        System.out.println("count = " + count);
    }
    @Override
    public void run() {
        addCount();
    }
}

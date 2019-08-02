package top.wujinxing.ch_6_thread.thread.book_core_thread.test_volatile;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: wujinxing
 * @date: 2019/2/28 17:56
 * @description: 原子类在具有逻辑性的情况下输出结果也具有随机性
 */
public class Test4_notSafe_Atom {
    public static void main(String[] args){
        try {
            MyService4 service = new MyService4();
            MyThread4[] array = new MyThread4[5];
            for (int i = 0; i < array.length; i++){
                array[i] = new MyThread4(service);
            }
            for (int i = 0; i < array.length; i++){
                array[i].start();
            }
            Thread.sleep(1000);
            System.out.println(service);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyService4{
    public static AtomicLong aiRef = new AtomicLong();
    synchronized public void addNum(){
        System.out.println(Thread.currentThread().getName() + " 加了100之后的值是："
            + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }
}

class MyThread4 extends Thread{
    private MyService4 myService;
    public MyThread4(MyService4 myService){
        super();
        this.myService = myService;
    }
    @Override
    public void run() {
        myService.addNum();
    }
}
package top.wujinxing.Thread.book_core_thread.test_volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: wujinxing
 * @date: 2019/2/28 17:40
 * @description:    使用AtomicInteger实现同步
 */
public class Test3_Atomic {
    public static void main(String[] args){
        AddCountThread3 countThread3 = new AddCountThread3();
        //以后尽量使用线程池，避免显示创建线程
        Thread t1 = new Thread(countThread3);
        t1.start();
        Thread t2 = new Thread(countThread3);
        t2.start();
        Thread t3 = new Thread(countThread3);
        t3.start();
        Thread t4 = new Thread(countThread3);
        t4.start();
        Thread t5 = new Thread(countThread3);
        t5.start();
        //成功累加到50000
    }
}

class AddCountThread3 extends Thread{
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            System.out.println(count.incrementAndGet());
        }
    }
}
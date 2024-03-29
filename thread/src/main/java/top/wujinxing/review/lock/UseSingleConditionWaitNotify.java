package top.wujinxing.review.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wujinxing
 * date 2019 2019/8/15 17:19
 * description 使用Condition实现等待/通知机制
 */
public class UseSingleConditionWaitNotify {
    public static void main(String[] args) throws InterruptedException {

        MyService myService = new MyService();

        MyService.ThreadA a = new MyService.ThreadA(myService);
        a.start();

        Thread.sleep(3000);
        myService.signal();
    }

    static class MyService{
        private Lock lock = new ReentrantLock();
        public Condition condition = lock.newCondition();

        public void await(){
            lock.lock();
            try {
                System.out.println("await时间为：" + System.currentTimeMillis());
                condition.await();
                System.out.println("这是condition.await()方法之后的语句，condition.signal()方法之后我才被执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void signal(){
            lock.lock();
            try {
                System.out.println("signal的时间为：" + System.currentTimeMillis());
                condition.signal();
                Thread.sleep(3000);
                System.out.println("这是condition.signal()方法之后的语句");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        static class ThreadA extends Thread{
            private MyService myService;

            public ThreadA(MyService myService){
                this.myService = myService;
            }

            @Override
            public void run() {
                myService.await();
            }
        }
    }
}

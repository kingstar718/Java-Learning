package top.wujinxing.Thread.book_art_thread;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wujinxing
 * date 2019 2019/5/28 17:16
 * description 公平锁与非公平锁的性能测试
 */
public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock(true);
    private static Lock unfairLock = new ReentrantLock(false);

    private void testLock(Lock lock){

    }
    private static class Job extends Thread{
        private Lock lock;
        public Job(Lock lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            super.run();
        }
    }
}

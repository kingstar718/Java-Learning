package top.wujinxing.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kingstar718
 * @date 2023/8/18
 */
@Slf4j
public class PrintABC2 {

    private static int state = 0;

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition A = lock.newCondition();
    private static final Condition B = lock.newCondition();
    private static final Condition C = lock.newCondition();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 0) {
                        // 被唤醒
                        A.await();
                    }
                    log.info(Thread.currentThread().getName() + " " + "A" + " " + state);
                    state++;
                    // 唤醒下一个线程
                    B.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 1) {
                        B.await();
                    }
                    log.info(Thread.currentThread().getName() + " " + "B" + " " + state);
                    state++;
                    C.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread threadC = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 2) {
                        C.await();
                    }
                    log.info(Thread.currentThread().getName() + " " + "C" + " " + state);
                    state++;
                    A.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}

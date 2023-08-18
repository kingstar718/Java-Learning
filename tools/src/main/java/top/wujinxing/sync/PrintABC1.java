package top.wujinxing.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kingstar718
 * @date 2023/8/18
 */
@Slf4j
public class PrintABC1 {

    private static int state = 0;

    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    synchronized (LOCK) {
                        while (state % 3 != 0) {
                            // wait() 会将当前线程挂起，不再 持有这个对象的所有权
                            LOCK.wait();
                        }
                        log.info(Thread.currentThread().getName() + " " + "A");
                        state++;
                        // notifyAll() 通知其他线程
                        LOCK.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                log.error("error: ", e);
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    synchronized (LOCK) {
                        while (state % 3 != 1) {
                            LOCK.wait();
                        }
                        log.info(Thread.currentThread().getName() + " " + "B");
                        state++;
                        LOCK.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                log.error("error: ", e);
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    synchronized (LOCK) {
                        while (state % 3 != 2) {
                            LOCK.wait();
                        }
                        log.info(Thread.currentThread().getName() + " " + "C");
                        state++;
                        LOCK.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                log.error("error: ", e);
            }
        });

        threadA.start();;
        threadB.start();
        threadC.start();

    }


}

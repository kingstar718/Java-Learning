package top.wujinxing.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @author kingstar718
 * @date 2023/8/18
 */
@Slf4j
public class PrintABC3 {

    private static int state = 0;

    private static final Semaphore A = new Semaphore(1);
    private static final Semaphore B = new Semaphore(0);
    private static final Semaphore C = new Semaphore(0);

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
           try {
               for (int i = 0; i < 100; i++) {
                   // 获得许可
                   A.acquire();
                   log.info(Thread.currentThread().getName() + " " + "A" + " " + state);
                   state++;
                   // 释放许可
                   B.release();
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });
        Thread threadB = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    B.acquire();
                    log.info(Thread.currentThread().getName() + " " + "B" + " " + state);
                    state++;
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    C.acquire();
                    log.info(Thread.currentThread().getName() + " " + "C" + " " + state);
                    state++;
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

    }

}

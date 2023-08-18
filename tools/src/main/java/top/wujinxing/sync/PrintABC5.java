package top.wujinxing.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author kingstar718
 * @date 2023/8/18
 */
@Slf4j
public class PrintABC5 {

    private static int state = 0;
    private static int threadNum = 3;

    /**
     * 创建一个屏障对象，指定一个参数与等待线程数和一个到达屏障点时的动作
     */
    private static final CyclicBarrier BARRIER = new CyclicBarrier(threadNum, () -> {
        switch (state) {
            case 0:
                log.info(Thread.currentThread().getName() + " " + "A" + " " + state);
                break;
            case 1:
                log.info(Thread.currentThread().getName() + " " + "B" + " " + state);
                break;
            case 2:
                log.info(Thread.currentThread().getName() + " " + "C" + " " + state);
                break;
            default:
                break;
        }
        state = (state + 1) % 3;
        log.info("{}", state);
    });

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            try {
                for (int i = 0; i < threadNum * 100; i++) {
                    // 线程执行完自己的任务后，调用await后，等待其他线程到达屏障点
                    BARRIER.await();
                }
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                for (int i = 0; i < threadNum * 100; i++) {
                    BARRIER.await();
                }
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                for (int i = 0; i < threadNum * 100; i++) {
                    BARRIER.await();
                }
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

}

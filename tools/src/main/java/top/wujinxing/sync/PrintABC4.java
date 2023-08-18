package top.wujinxing.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kingstar718
 * @date 2023/8/18
 */
@Slf4j
public class PrintABC4 {

    private static AtomicInteger state = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 100;) {
                if (state.get() % 3 == 0) {
                    log.info(Thread.currentThread().getName() + " " + "A" + " " + state.get());
                    state.compareAndSet(state.get(), state.get() + 1);
                    i++;
                }
            }
        });
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 100;) {
                if (state.get() % 3 == 1) {
                    log.info(Thread.currentThread().getName() + " " + "B" + " " + state.get());
                    state.compareAndSet(state.get(), state.get() + 1);
                    i++;
                }
            }
        });
        Thread threadC = new Thread(() -> {
            for (int i = 0; i < 100;) {
                if (state.get() % 3 == 2) {
                    log.info(Thread.currentThread().getName() + " " + "C" + " " + state.get());
                    state.compareAndSet(state.get(), state.get() + 1);
                    i++;
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

    }

}

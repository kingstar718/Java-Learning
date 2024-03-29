package top.wujinxing.threadframe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wujinxing
 * date 2019 2019/5/5 15:41
 * description 使用循环CAS实现原子操作
 * <p>
 * 实现一个基于CAS线程安全的计数器方法safeCount和一个非线程安全的计数器count
 */
public class CasDemo {

    private final AtomicInteger atomicI = new AtomicInteger(0);

    private int i = 0;

    public static void main(String[] args) {
        final CasDemo cas = new CasDemo();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }
        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            try {
                // Blocks the current Thread (<code>Thread.currentThread()</code>)
                // until the receiver finishes its execution and dies.
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    private void safeCount() {
        for (; ; ) {
            int i = atomicI.get();
            //检查值有没有发生变化, 变化才更新
            boolean suc = atomicI.weakCompareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    private void count() {
        i++;
    }

}

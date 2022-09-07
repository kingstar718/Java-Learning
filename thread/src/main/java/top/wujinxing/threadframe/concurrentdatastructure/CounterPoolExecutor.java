package top.wujinxing.threadframe.concurrentdatastructure;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wujinxing
 * @date 2019/3/27 11:03
 */
public class CounterPoolExecutor extends ThreadPoolExecutor {

    /** 统计执行的次数 */
    private final AtomicInteger count = new AtomicInteger(0);

    public long startTime = 0;

    public String funcname = "";

    public CounterPoolExecutor(int corePoolSize, int maximumPoolSize,  //统计任务完成的次数
                               long keepAliveTime, TimeUnit unit,
                               BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {

        int l = count.addAndGet(1);

        super.afterExecute(r, t);

    }

}

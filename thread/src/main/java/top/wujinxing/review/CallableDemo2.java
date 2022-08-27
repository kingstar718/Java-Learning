package top.wujinxing.review;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wujinxing
 * date 2019 2019/12/26 9:48
 * description 通过ExecutorService和Callable<Class>实现有返回任务的线程
 */
public class CallableDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        // 创建多个有返回值的任务列表list
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Callable c = new MyCallable(i + " ");
            // 提交线程，获取Future对象并将其保存到Future List中
            Future future = pool.submit(c);
            System.out.println("submit a callable thread: " + i);
            list.add(future);
        }
        //关闭线程池，等待线程执行结束
        pool.shutdown();
        // 遍历所有的线程运行结果
        for (Future future : list) {
            System.out.println("get the result from callable thread: " + future.get().toString());
        }

    }

    static class MyCallable implements Callable<String> {

        private String name;

        public MyCallable(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            return name;
        }
    }
}

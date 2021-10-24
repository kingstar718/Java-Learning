package top.wujinxing.ch_6_thread.compeletionservice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wujinxing
 */
@Slf4j
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {

        Long start = System.currentTimeMillis();

        ExecutorService exs = Executors.newFixedThreadPool(3);

        try {
            int taskCount = 10;

            List<Integer> list = new ArrayList<>();
            List<Future<Integer>> futureList = new ArrayList<>();

            // 1、定义CompletionService
            CompletionService<Integer> completionService = new ExecutorCompletionService<>(exs);

            // 2、添加任务
            for (int i = 0; i < taskCount; i++) {
                Future<Integer> future = completionService.submit(new Task(i + 1));
                futureList.add(future);
            }

            // 3、获取结果
            for (int i = 0; i < taskCount; i++) {
                Integer result = completionService.take().get();
                log.info("task i== {} success! {}", result, new Date());
                list.add(result);
            }
            log.info("result = {}", list);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            exs.shutdown();
        }
    }

    static class Task implements Callable<Integer> {

        Integer i;

        Task(Integer i) {
            super();
            this.i = i;
        }

        @Override
        public Integer call() throws Exception {
            if (i == 5) {
                Thread.sleep(5000);
            } else {
                Thread.sleep(1000);
            }
            log.info("线程：{} 任务i={}, 执行完成！", Thread.currentThread().getName(), i);
            return i;
        }
    }
}

package top.wujinxing.review.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wujinxing
 * date 2019 2019/8/20 15:27
 * description 有返回值的任务（使用线程池）
 */
public class ThreadPoolDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int taskSize = 10;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);

        //创建多个返回值的任务
        List<Future> list = new ArrayList<>();
        for (int i=0; i<taskSize; i++){
            Callable c = new MyCallable(i + "_callable");

            //执行任务并获取Future对象
            Future f = pool.submit(c);

            list.add(f);
        }
        pool.shutdown();

        // 获取所有并发任务的运行结果
        for (Future f: list){
            // 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println("res: " + f.get().toString());
        }
    }

    static class MyCallable implements Callable{

        String s;

        public MyCallable(String s){
            this.s = s;
        }

        @Override
        public Object call() throws Exception {
            return s;
        }
    }
}

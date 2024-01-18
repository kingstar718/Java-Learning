package top.wujinxing.redisson;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

/**
 * @author 01397208
 * @date 2024/1/16
 */
@Slf4j
public class RedissonUtil {

    public static void main(String[] args) throws InterruptedException {
        //objectBucket();
        //longAddr();
        //delayedQueue();
        //getDelayQueue();
        //delayedQueue();

        //task();

        //atomicLong();



        RedissonClient redisson = getRedissonClient();

        tryLock(redisson);

        //ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        //scheduled.scheduleAtFixedRate(() -> tryLock(redisson), 5, 5, TimeUnit.SECONDS);
    }

    public static RedissonClient getRedissonClient() {
        Config config = new Config();
        // 默认是NIO
        //config.setTransportMode(TransportMode.EPOLL);
        config.setCodec(new StringCodec())
                .useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                .setConnectTimeout(3000)
                .setTimeout(3000);
        return Redisson.create(config);
    }


    public static void objectBucket() {
        RedissonClient redisson = getRedissonClient();
        RBucket<String> bucket = redisson.getBucket("anyObject");
        bucket.set(JSON.toJSONString(new AnyObject(1L, "Li", 23)));
        String anyObject = bucket.get();
        log.info("anyObject: {}", anyObject);
    }

    public static void longAddr() {
        RedissonClient redisson = getRedissonClient();
        RLongAdder longAddr = redisson.getLongAdder("longAddr");
        longAddr.add(12);
        longAddr.increment();
        longAddr.decrement();
        longAddr.decrement();
        log.info("longAddr: {}", longAddr.sum());
    }


    public static void delayedQueue() {
        RedissonClient redisson = getRedissonClient();
        RBlockingDeque<String> rQueue = redisson.getBlockingDeque("orderQueue");
        RDelayedQueue<String> delayedQueue = redisson.getDelayedQueue(rQueue);

        log.info("time: {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        delayedQueue.offer("任务1", 15, TimeUnit.SECONDS);
        delayedQueue.offer("任务2", 13, TimeUnit.SECONDS);
        delayedQueue.offer("任务3", 19, TimeUnit.SECONDS);
    }

    public static void getDelayQueue() {
        RedissonClient redisson = getRedissonClient();
        RBlockingDeque<String> rQueue = redisson.getBlockingDeque("orderQueue");
        RDelayedQueue<String> delayedQueue = redisson.getDelayedQueue(rQueue);
        while (true) {
            try {
                String take = rQueue.take();
                log.info("time: {}, 任务: {} 收到", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), take);
            } catch (InterruptedException e) {
                log.error("r queue take failed: ", e);
            }
        }
    }

    public static void task() {
        // 任务的添加与执行
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(RedissonUtil::getDelayQueue);
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        scheduled.scheduleAtFixedRate(RedissonUtil::delayedQueue, 5, 20, TimeUnit.SECONDS);
    }


    public static void atomicLong() {
        RedissonClient redisson = getRedissonClient();
        RAtomicLong atomicLong = redisson.getAtomicLong("atomicLong");
        atomicLong.incrementAndGet();
        log.info("atomic long: {}", atomicLong.get());
    }


    public static void tryLock(RedissonClient redisson) {
        RLock tryLock = redisson.getLock("tryLock");
        try {
            boolean lock = tryLock.tryLock(2, 3, TimeUnit.SECONDS);
            if (lock) {
                log.info("获取锁成功");
            }
        } catch (InterruptedException e) {
            log.error("try lock failed: ", e);
        }
    }


    @Data
    static class AnyObject implements Serializable {
        private Long id;
        private String name;
        private Integer age;

        public AnyObject(Long id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }


}

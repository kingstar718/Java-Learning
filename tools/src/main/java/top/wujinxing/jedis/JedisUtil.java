package top.wujinxing.jedis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wujinxing
 * @date 2023-01-08
 */
@Slf4j
public class JedisUtil {

    private JedisUtil() {
        init();
    }

    private static JedisPool pool = null;

    private static void init() {
        log.debug("init jedis pool start.");
        final ResourceBundle rb = ResourceBundle.getBundle("jedis");
        final String host = rb.getString("jedis.host");
        final int post = Integer.parseInt(rb.getString("jedis.post"));
        final int maxTotal = Integer.parseInt(rb.getString("jedis.maxTotal"));
        final int maxIdle = Integer.parseInt(rb.getString("jedis.maxIdle"));
        final int maxWaitMillis = Integer.parseInt(rb.getString("jedis.maxWaitMillis"));

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        pool = new JedisPool(jedisPoolConfig, host, post);
        log.debug("jedis pool init success.");

        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.scheduleAtFixedRate(() -> {
            log.debug("pool numActive:{}, numIdle:{}, numWaiters:{}",
                    pool.getNumActive(), pool.getNumIdle(), pool.getNumWaiters());
        }, 10, 5, TimeUnit.SECONDS);
    }

    public static Jedis getJedis() {
        if (pool == null) {
            init();
        }
        return pool.getResource();
    }

    public static String get(String key) {
        Jedis jedis = getJedis();
        String value = jedis.get(key);
        close(jedis);
        return value;
    }

    public static void set(String key, String value) {
        Jedis jedis = getJedis();
        jedis.set(key, value);
        close(jedis);
    }

    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}

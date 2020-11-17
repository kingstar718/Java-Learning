package top.wujinxing.ch_7_tools.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {

    private static JedisPool pool;

    static {
        String host = "127.0.0.1";
        String port = "6379";
        JedisPoolConfig config = new JedisPoolConfig();
        pool = new JedisPool(config, host);
    }

    public static Jedis getJedis() {
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

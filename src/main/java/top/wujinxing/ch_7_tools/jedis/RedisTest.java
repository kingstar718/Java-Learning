package top.wujinxing.ch_7_tools.jedis;

public class RedisTest {

    public static void main(String[] args) {
        JedisUtil.set("1", "李哥");
        JedisUtil.set("2", "ak");
        System.out.println(JedisUtil.get("1"));
        System.out.println(JedisUtil.get("2"));
    }
}

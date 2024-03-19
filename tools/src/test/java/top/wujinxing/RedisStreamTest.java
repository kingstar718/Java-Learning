package top.wujinxing;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.StreamEntry;
import redis.clients.jedis.StreamEntryID;
import top.wujinxing.jedis.JedisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 01397208
 * @date 2024/3/18
 * 参考文章：
 * 1、https://blog.csdn.net/FlyLikeButterfly/article/details/109533772
 * 2、https://blog.csdn.net/whzhaochao/article/details/112617905
 * 3、https://www.runoob.com/redis/redis-stream.html
 */
@Slf4j
public class RedisStreamTest {
    /**
     * XADD - 添加消息到末尾
     * XTRIM - 对流进行修剪，限制长度
     * XDEL - 删除消息
     * XLEN - 获取流包含的元素数量，即消息长度
     * XRANGE - 获取消息列表，会自动过滤已经删除的消息
     * XREVRANGE - 反向获取消息列表，ID 从大到小
     * XREAD - 以阻塞或非阻塞方式获取消息列表
     * <p>
     * XGROUP CREATE - 创建消费者组
     * XREADGROUP GROUP - 读取消费者组中的消息
     * XACK - 将消息标记为"已处理"
     * XGROUP SETID - 为消费者组设置新的最后递送消息ID
     * XGROUP DELCONSUMER - 删除消费者
     * XGROUP DESTROY - 删除消费者组
     * XPENDING - 显示待处理消息的相关信息
     * XCLAIM - 转移消息的归属权
     * XINFO - 查看流和消费者组的相关信息；
     * XINFO GROUPS - 打印消费者组的信息；
     * XINFO STREAM - 打印流信息
     */

    @Test
    public void xAddTest() {
        Jedis jedis = JedisUtil.getJedis();

        Map<String, String> hash1 = new HashMap<>(2);
        hash1.put("name", "Tom");
        hash1.put("age", "13");
        StreamEntryID streamEntryID = jedis.xadd("myStream", StreamEntryID.NEW_ENTRY, hash1);
        log.info("map: {}, stream entity id: {}", hash1, streamEntryID);

        Map<String, String> hash2 = new HashMap<>(2);
        hash2.put("name", "Jerry");
        hash2.put("age", "15");
        StreamEntryID streamEntryID2 = jedis.xadd("myStream", StreamEntryID.NEW_ENTRY, hash2);
        log.info("map: {}, stream entity id: {}", hash2, streamEntryID2);
    }

    @Test
    public void xLen() {
        Jedis jedis = JedisUtil.getJedis();
        Long myStream = jedis.xlen("myStream");
        log.info("my stream x len: {}", myStream);
    }

    /**
     * XREAD - 以阻塞或非阻塞方式获取消息列表
     * XREAD [COUNT count] [BLOCK milliseconds] STREAMS key [key ...] id [id ...]
     * count 数量
     * milliseconds 可选，阻塞毫秒数，没有设置就是非阻塞模式
     * key 队列名
     * id 消息id
     */
    @Test
    public void xRead() {
        Jedis jedis = JedisUtil.getJedis();
        List<Map.Entry<String, List<StreamEntry>>> xread = jedis.xread(1, 3000,
                new MyEntry("myStream", "1710751548714-0"),
                new MyEntry("myStream", "1710751548707-0"));
        log.info("x read list: {}", xread);
    }


    /**
     * XRANGE - 获取消息列表，会自动过滤已经删除的消息
     */
    @Test
    public void xRange() {
        Jedis jedis = JedisUtil.getJedis();
        // null 表示无穷小或者无穷大
        List<StreamEntry> myStream = jedis.xrange("myStream", null, null, 100);
        log.info("x range result: {}", myStream);
    }

    /**
     * XREVRANGE - 反向获取消息列表，ID 从大到小
     */
    @Test
    public void xRevrange() {
        Jedis jedis = JedisUtil.getJedis();
        // null 表示无穷小或者无穷大
        List<StreamEntry> myStream = jedis.xrevrange("myStream", null, null, 100);
        log.info("x rev range result: {}", myStream);
    }


    /**
     * XDEL - 删除消息
     */
    @Test
    public void xDel() {
        Jedis jedis = JedisUtil.getJedis();
        List<Map.Entry<String, List<StreamEntry>>> myStream = jedis.xread(1, 0, new MyEntry("myStream", "0"));
        Map.Entry<String, List<StreamEntry>> stringListEntry = myStream.get(0);
        List<StreamEntry> value = stringListEntry.getValue();
        String id = value.get(0).getID().toString();
        log.info("x del id: {}", id);
        long result = jedis.xdel("myStream", new StreamEntryID(id));
        log.info("x del id: {}, result: {}", id, result);
    }


    /**
     * XGROUP CREATE - 创建消费者组
     * XGROUP [CREATE key groupname id-or-$] [SETID key groupname id-or-$] [DESTROY key groupname] [DELCONSUMER key groupname consumername]
     * key 队列名称，如果不存在就创建
     * groupname 组名
     * $ 表示从尾部开始消费消息，只接受新消息，当前Stream消息会全部忽略
     * 例子：
     * 1-头开始消费：XGROUP CREATE mystream consumer-group-name 0-0
     * 2-从尾部开始消费：XGROUP CREATE mystream consumer-group-name $
     */
    @Test
    public void xGroupCreate() {
        Jedis jedis = JedisUtil.getJedis();
        String group1 = jedis.xgroupCreate("myStream", "group1", null, true);
        log.info("x group create: {}", group1);
    }

    /**
     * XREADGROUP GROUP 使用 XREADGROUP GROUP 读取消费组中的消息
     * XREADGROUP GROUP group consumer [COUNT count] [BLOCK milliseconds] [NOACK] STREAMS key [key ...] ID [ID ...]
     * group 消费组名
     * consumer 消费者名
     * count 读取数量
     * milliseconds 阻塞毫秒数
     * key 队列名
     * ID 消息ID
     * 例子：XREADGROUP GROUP consumer-group-name consumer-name COUNT 1 STREAMS mystream >
     */
    @Test
    public void xReadGroup() {
        Jedis jedis = JedisUtil.getJedis();
        List<Map.Entry<String, List<StreamEntry>>> entries = jedis.xreadGroup("group1", "client1", 2, 1000, false,
                new MyEntry("myStream", StreamEntryID.UNRECEIVED_ENTRY));
        log.info("x read group list: {}", entries);
    }

    static class MyEntry implements Map.Entry<String, StreamEntryID> {

        private String k;
        private StreamEntryID id;

        public MyEntry(String k, String id) {
            this.k = k;
            if ("0".equals(id)) {
                this.id = new StreamEntryID();
            } else {
                this.id = new StreamEntryID(id);
            }
        }

        public MyEntry(String k, StreamEntryID id) {
            this.k = k;
            this.id = id;
        }

        @Override
        public String getKey() {
            return k;
        }

        @Override
        public StreamEntryID getValue() {
            return id;
        }

        @Override
        public StreamEntryID setValue(StreamEntryID value) {
            this.id = value;
            return id;
        }
    }

}

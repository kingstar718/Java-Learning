package top.wujinxing.ch_7_tools.hbase;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author wujinxing
 * 2021-09-11
 */
@Slf4j
public class HBaseTest {

    static Configuration conf = null;

    public static boolean isTableExists(String tableName) {
        try (Connection connection = ConnectionFactory.createConnection(conf)) {
            Admin admin = connection.getAdmin();
            return admin.tableExists(TableName.valueOf(tableName));
        } catch (IOException e) {
            log.info("static is table exists failed: ", e);
        }
        return false;
    }

    @Before
    public void connect() {
        BasicConfigurator.configure();
        String quorum = "localhost";
        String clientPort = "2181";
        conf = HBaseConfiguration.create();
        // zk地址
        conf.set("hbase.zookeeper.quorum", quorum);
        // zk端口
        conf.set("hbase.zookeeper.property.clientPort", clientPort);
    }

    public static void createTable(String tableName, String... columnFamily) {
        try (Connection connection = ConnectionFactory.createConnection(conf)) {
            Admin admin = connection.getAdmin();
            if (isTableExists(tableName)) {
                log.info("table exists");
                return;
            }
            HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
            for (String cf : columnFamily) {
                HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(cf);
                hColumnDescriptor.setMinVersions(1);
                hColumnDescriptor.setMaxVersions(1);
                hTableDescriptor.addFamily(hColumnDescriptor);
            }
            admin.createTable(hTableDescriptor);
            log.info("table: {} and columns: {} created!", tableName, Arrays.toString(columnFamily));
        } catch (IOException e) {
            log.error("static create table failed: ", e);
        }
    }

    public static void dropTable(String tableName) {
        try (Connection connection = ConnectionFactory.createConnection(conf);
             Admin admin = connection.getAdmin()) {
            if (isTableExists(tableName)) {
                TableName value = TableName.valueOf(tableName);
                admin.disableTable(value);
                admin.deleteTable(value);
                log.info("table: {} delete success", tableName);
            }
        } catch (IOException e) {
            log.error("table: {} delete failed, reason: ", tableName, e);
        }
    }

    public static void addRowDate(String tableName, String rowKey, String columnFamily, String colName, String value) {
        try (Connection connection = ConnectionFactory.createConnection(conf);
             Table table = connection.getTable(TableName.valueOf(tableName))) {
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(colName), Bytes.toBytes(value));
            table.put(put);
        } catch (IOException e) {
            log.error("static add row data failed, reason: ", e);
        }
    }

    public static void getByRowKeys(String tableName, String rowKey) {
        try (Connection connection = ConnectionFactory.createConnection(conf);
             Table table = connection.getTable(TableName.valueOf(tableName))) {
            Get get = new Get(Bytes.toBytes(rowKey));
            Result result = table.get(get);
            Cell[] rowCell = result.rawCells();
            for (Cell cell: rowCell) {
                log.info("----------");
                log.info(Bytes.toString(CellUtil.cloneRow(cell)));
                log.info(Bytes.toString(CellUtil.cloneFamily(cell)));
                log.info(Bytes.toString(CellUtil.cloneQualifier(cell)));
                log.info(Bytes.toString(CellUtil.cloneValue(cell)));
            }
        } catch (IOException e) {
            log.error("static add row data failed, reason: ", e);
        }
    }


    @Test
    public void test() throws IOException {
        String tableName = "user1";
        log.info("table exists: {}", isTableExists(tableName));
        createTable(tableName, "message", "learn");
        addRowDate(tableName, "user1", "message", "name", "张三");
        addRowDate(tableName, "user2", "message", "name", "李四");
        addRowDate(tableName, "user3", "message", "name", "王五");
        addRowDate(tableName, "user1", "message", "age", "18");
        addRowDate(tableName, "user2", "message", "age", "19");
        addRowDate(tableName, "user3", "message", "age", "20");

        addRowDate(tableName, "user1", "learn", "class", "语文");
        addRowDate(tableName, "user2", "learn", "class", "数学");
        addRowDate(tableName, "user3", "learn", "class", "英语");
        addRowDate(tableName, "user1", "learn", "score", "97");
        addRowDate(tableName, "user2", "learn", "class", "98");
        addRowDate(tableName, "user3", "learn", "class", "99");

        getByRowKeys(tableName, "user1");
    }
}

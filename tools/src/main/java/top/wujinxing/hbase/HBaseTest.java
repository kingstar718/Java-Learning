package top.wujinxing.hbase;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
//import org.apache.log4j.BasicConfigurator;
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
        //BasicConfigurator.configure();
        String quorum = "localhost";
        String clientPort = "2181";
        conf = HBaseConfiguration.create();
        // zk地址
        conf.set("hbase.zookeeper.quorum", quorum);
        // zk端口
        conf.set("hbase.zookeeper.property.clientPort", clientPort);
    }

    /**
     * 创建表
     *
     * @param tableName    /
     * @param columnFamily /
     */
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

    /**
     * 删除表
     *
     * @param tableName /
     */
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

    public static void addRowData(String tableName, String rowKey, String columnFamily, String colName, String value) {
        try (Connection connection = ConnectionFactory.createConnection(conf);
             Table table = connection.getTable(TableName.valueOf(tableName))) {
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(colName), Bytes.toBytes(value));
            table.put(put);
        } catch (IOException e) {
            log.error("static add row data failed, reason: ", e);
        }
    }

    /**
     * 删除指定列族的数据
     *
     * @param tableName     /
     * @param rowKey        /
     * @param columnFamilys /
     * @param column        /
     */
    public static void deleteColumnFamily(String tableName, String rowKey, String columnFamilys, String column) {
        try (Connection connection = ConnectionFactory.createConnection(conf);
             Table table = connection.getTable(TableName.valueOf(tableName))) {
            Delete delete = new Delete(Bytes.toBytes(rowKey));
            delete.addColumn(Bytes.toBytes(columnFamilys), Bytes.toBytes(column));
            table.delete(delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过scan来获取数据
     *
     * @param tableName /
     */
    public static void getAllRows(String tableName) {
        try (Connection connection = ConnectionFactory.createConnection(conf);
             Table table = connection.getTable(TableName.valueOf(tableName))) {
            Scan scan = new Scan();
            ResultScanner scanner = table.getScanner(scan);
            for (Result result : scanner) {
                Cell[] rawCell = result.rawCells();
                for (Cell cell : rawCell) {
                    log.info("----------");
                    log.info(Bytes.toString(CellUtil.cloneRow(cell)));
                    log.info(Bytes.toString(CellUtil.cloneFamily(cell)));
                    log.info(Bytes.toString(CellUtil.cloneQualifier(cell)));
                    log.info(Bytes.toString(CellUtil.cloneValue(cell)));
                }
            }
        } catch (IOException e) {
            log.error("static get all rows failed: ", e);
        }
    }


    /**
     * 得到所有的数据
     *
     * @param tableName /
     * @param rowKey    /
     */
    public static void getByRowKeys(String tableName, String rowKey) {
        try (Connection connection = ConnectionFactory.createConnection(conf);
             Table table = connection.getTable(TableName.valueOf(tableName))) {
            Get get = new Get(Bytes.toBytes(rowKey));
            Result result = table.get(get);
            Cell[] rowCell = result.rawCells();
            for (Cell cell : rowCell) {
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

    public static void getDataFamilyFilter(String tableName, String family) {
        try (Connection connection = ConnectionFactory.createConnection(conf);
             Table table = connection.getTable(TableName.valueOf(tableName))) {
            // 表中不存在account列表，过滤结果为空
            FamilyFilter familyFilter = new FamilyFilter(CompareFilter.CompareOp.EQUAL,
                    //new BinaryPrefixComparator(value)  // 匹配字节数组前缀
                    //new RegexStringComparator(expr) //正则表达式匹配
                    //new SubstringComparator(substr) // 子字符串匹配
                    new BinaryComparator(Bytes.toBytes(family)));
            Scan scan = new Scan();
            //scan.addFamily(Bytes.toBytes(family)); // 通过这个也可以实现此操作
            scan.setFilter(familyFilter);
            ResultScanner resultScanner = table.getScanner(scan);
            printResultScanner(resultScanner);
        } catch (IOException e) {
            log.error("static get data family filter failed: ", e);
        }
    }

    public static void printResultScanner(ResultScanner scanner) {
        if (scanner != null) {
            for (Result result : scanner) {
                Cell[] rowCell = result.rawCells();
                for (Cell cell : rowCell) {
                    log.info("----------");
                    log.info(Bytes.toString(CellUtil.cloneRow(cell)));
                    log.info(Bytes.toString(CellUtil.cloneFamily(cell)));
                    log.info(Bytes.toString(CellUtil.cloneQualifier(cell)));
                    log.info(Bytes.toString(CellUtil.cloneValue(cell)));
                }
            }
        }
    }


    @Test
    public void test() throws IOException {
        String tableName = "user1";
        log.info("table exists: {}", isTableExists(tableName));
        createTable(tableName, "message", "learn");
        addRowData(tableName, "user1", "message", "name", "张三");
        addRowData(tableName, "user2", "message", "name", "李四");
        addRowData(tableName, "user3", "message", "name", "王五");
        addRowData(tableName, "user1", "message", "age", "18");
        addRowData(tableName, "user2", "message", "age", "19");
        addRowData(tableName, "user3", "message", "age", "20");

        addRowData(tableName, "user1", "learn", "class", "语文");
        addRowData(tableName, "user2", "learn", "class", "数学");
        addRowData(tableName, "user3", "learn", "class", "英语");
        addRowData(tableName, "user1", "learn", "score", "97");
        addRowData(tableName, "user2", "learn", "class", "98");
        addRowData(tableName, "user3", "learn", "class", "99");

        getByRowKeys(tableName, "user1");
    }

    @Test
    public void scanTest() {
        String tableName = "user1";
        getAllRows(tableName);
    }

    @Test
    public void testFilter() {
        String tableName = "user1";
        getDataFamilyFilter(tableName, "message");
    }
}

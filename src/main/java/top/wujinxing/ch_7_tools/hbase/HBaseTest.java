package top.wujinxing.ch_7_tools.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

/**
 * @author wujinxing
 * 2021-09-11
 */

public class HBaseTest {

    @Test
    public void test() {

        Connection connection = null;
        Table table = null;
        try {

            String clientPort = "2181";
            String quorum = "";

            Configuration configuration = HBaseConfiguration.create();
            configuration.set("hbase.zookeeper.property.clientPort", clientPort);
            configuration.set("hbase.zookeeper.quorum", quorum);


            //HBaseAdmin.checkHBaseAvailable(configuration);
            connection = ConnectionFactory.createConnection(configuration);
            Admin admin = connection.getAdmin();
            TableName tableName = TableName.valueOf("tbl_user");
            boolean tableExists = admin.tableExists(tableName);
            System.out.println(tableExists);
            table = connection.getTable(tableName);

            // 通过rowKey查询
            Get get = new Get(Bytes.toBytes("mengday"));
            Result result = table.get(get);
            Cell[] cells = result.rawCells();
            for (Cell cell: cells) {
                System.out.println("----------");
                System.out.println(Bytes.toString(CellUtil.cloneRow(cell)));
                System.out.println(Bytes.toString(CellUtil.cloneFamily(cell)));
                System.out.println(Bytes.toString(CellUtil.cloneQualifier(cell)));
                System.out.println(Bytes.toString(CellUtil.cloneValue(cell)));
            }
        } catch (Exception e) {
            System.out.println("hbase test error:"+ e);
        }
    }
}

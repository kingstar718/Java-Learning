package top.wujinxing.influxdb;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;

import java.time.Instant;
import java.util.List;

/**
 * @author kingstar718
 * @date 2023/8/18
 * <p>
 * 参考链接：https://github.com/influxdata/influxdb-client-java/tree/master/client#influxdb-client-java
 */
public class InfluxDbDemo {

    private static char[] token = "uVuJWHDb5-OtIgkPC13TkJe28Ccspi8v0IcOFA4R1fB6gzzJPi9Fv1BaxbqucqMeyXynEZexEFrrcS_5SvIqfA==".toCharArray();
    private static String org = "my-group";
    private static String bucket = "my-bucket";

    public static void main(String[] args) {
        //writeDemo();
        //queryData();
        queryDataToPojo();
    }

    private static InfluxDBClient getClient() {
        return InfluxDBClientFactory.create("http://localhost:8086", token, org, bucket);
    }


    private static void writeDemo() {
        InfluxDBClient client = getClient();
        // write data
        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        // write by data point
        Point point = Point.measurement("temperature")
                .addTag("location", "west")
                .addField("value", 55D)
                .time(Instant.now().toEpochMilli(), WritePrecision.MS);
        writeApi.writePoint(point);
        // write by LineProtocol
        writeApi.writeRecord(WritePrecision.NS, "temperature,location=north value=60.0");
        // write by POJO
        Temperature temperature = new Temperature();
        temperature.location = "south";
        temperature.value = 62D;
        temperature.time = Instant.now();
        writeApi.writeMeasurement(WritePrecision.NS, temperature);
        client.close();
    }

    private static void queryData() {
        InfluxDBClient client = getClient();
        // query data
        String flux = "from(bucket:\"my-bucket\") |> range(start: 0)";
        QueryApi queryApi = client.getQueryApi();
        List<FluxTable> tables = queryApi.query(flux);
        for (FluxTable table : tables) {
            List<FluxRecord> records = table.getRecords();
            for (FluxRecord record : records) {
                System.out.println(record.getTime() + ": " + record.getValueByKey("_value"));
            }
        }
        client.close();
    }


    private static void queryDataToPojo() {
        InfluxDBClient client = getClient();
        String flux = "from(bucket:\"my-bucket\") |> range(start: 0) |> filter(fn: (r) => r._measurement == \"temperature\")";
        QueryApi queryApi = client.getQueryApi();
        // Map to POJO
        List<Temperature> temperatures = queryApi.query(flux, Temperature.class);
        for (Temperature temperature : temperatures) {
            System.out.println(temperature.location + ": " + temperature.value + "at " + temperature.time);
        }
        client.close();
    }


    @Measurement(name = "temperature")
    public static class Temperature {

        @Column(tag = true)
        String location;

        @Column(tag = false)
        Double value;

        @Column(timestamp = true)
        Instant time;

    }

}

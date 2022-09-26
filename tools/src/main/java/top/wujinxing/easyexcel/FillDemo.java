package top.wujinxing.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author wujinxing
 * @date 2022-09-24
 */
public class FillDemo {

    @Test
    public void writeExcel() {
        String fileName = Thread.currentThread().getContextClassLoader().getResource("").getPath() + System.currentTimeMillis() + ".xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(data(), writeSheet);
        }
    }

    @Test
    public void listFill() {
        String templateFile = Thread.currentThread().getContextClassLoader().getResource("text.xlsx").getPath();
        String fileName = System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName).withTemplate(templateFile).sheet().doFill(data());
    }

    private List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

}

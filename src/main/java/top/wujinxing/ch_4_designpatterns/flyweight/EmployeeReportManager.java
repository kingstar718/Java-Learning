package top.wujinxing.ch_4_designpatterns.flyweight;

/**
 * @author: wujinxing
 * @date: 2019/3/25 13:50
 * @description:
 */
public class EmployeeReportManager implements IReportManager { //员工报表
    protected String tenantId = null;
    public EmployeeReportManager(String tenantId){  //租户ID
        this.tenantId = tenantId;
    }
    @Override
    public String createReport() {
        return "This is a employee report";
    }
}

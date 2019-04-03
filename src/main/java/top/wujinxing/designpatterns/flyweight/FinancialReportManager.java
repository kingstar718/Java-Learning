package top.wujinxing.designpatterns.flyweight;

/**
 * @author: wujinxing
 * @date: 2019/3/25 13:48
 * @description:
 */
public class FinancialReportManager implements IReportManager{ //财务报表
    protected String tenantId = null;

    public FinancialReportManager(String tenantId){ //租户ID
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a financial report";
    }
}

package top.wujinxing.DesignPatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wujinxing
 * @date: 2019/3/25 13:52
 * @description: 享元工厂类
 * 确保同一个公司(租户)使用相同的对象产生报表.
 * 否则系统可能会为每个员工生成各自的报表对象,导致系统开销激增
 */
public class ReportManagerFactory {

    Map<String, IReportManager> financialReportManager =
            new HashMap<>();
    Map<String, IReportManager> employeeReportManager =
            new HashMap<>();
    IReportManager getFinancialReportManager(String tenantId){
        IReportManager r = financialReportManager.get(tenantId);
        if (r==null){
            r = new FinancialReportManager(tenantId); //维护已创建的享元对象
            financialReportManager.put(tenantId, r);
        }
        return r;
    }

    IReportManager getEmployeeReportManager(String tenantId){
        IReportManager r = employeeReportManager.get(tenantId);
        if (r==null){
            r = new EmployeeReportManager(tenantId);
            employeeReportManager.put(tenantId, r); //维护已创建的享元对象
        }
        return r;
    }


}

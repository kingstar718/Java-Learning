package top.wujinxing.flyweight;

/**
 * @author: wujinxing
 * @date: 2019/3/25 14:30
 * @description: 使用享元模式的主函数
 */
public class flyweightMain {
    public static void main(String[] args){
        ReportManagerFactory rmf = new ReportManagerFactory();
        IReportManager rm = rmf.getFinancialReportManager("A");
        System.out.println(rm.createReport());
        IReportManager em = rmf.getEmployeeReportManager("B");
        System.out.println(rm.createReport());
    }
}

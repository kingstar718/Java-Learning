package top.wujinxing.DesignPatterns.flyweight;

/**
 * @author: wujinxing
 * @date: 2019/3/25 13:46
 * @description: 用于创建一个报表
 * 即,所有的报表生成类将作为享元对象在一个公司(租户)中共享
 */
public interface IReportManager {
    public String createReport();
}

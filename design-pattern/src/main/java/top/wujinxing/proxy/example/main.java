package top.wujinxing.proxy.example;

/**
 * @author: wujinxing
 * @date: 2019/3/25 08:54
 * @description:
 * IDBQuery是主题接口,定义代理类和真实类需要对外提供的服务
 * 本例中定义了实现数据库查询的公共方法request()函数
 * DBQuery是真实主题,负责实际业务的操作
 * DBProxyQuery是DBQuery的代理类
 */
public class main {
    public static void main(String[] args){
        IDBQuery q = new DBQueryProxy(); //使用代理
        q.request(); //只有在真正使用时才创建真实对象(没有该句,DBQuery构造函数不会执行)
    }
}

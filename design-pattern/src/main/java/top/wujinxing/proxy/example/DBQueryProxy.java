package top.wujinxing.proxy.example;

/**
 * @author: wujinxing
 * @date: 2019/3/25 09:03
 * @description: 轻量级对象,创建很快,用于替代DBQuery的位置
 */
public class DBQueryProxy implements IDBQuery{

    private DBQuery real = null;

    @Override
    public String request() {
        //在真正想要的时候,才创建真实对象,创建过程可能比较缓慢
        if (real==null){
            real = new DBQuery();
        }
        //多线程环境下,这里返回一个虚假类,类似于Future模式
        return real.request();
    }
}

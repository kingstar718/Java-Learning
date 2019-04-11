package top.wujinxing.DesignPatterns.proxy.example;

/**
 * @author: wujinxing
 * @date: 2019/3/25 09:00
 * @description: 是一个重量级对象,构造可能会比较慢
 */
public class DBQuery implements IDBQuery{

    public DBQuery(){
        //测试几种动态代理性能时,去掉sleep代码
        /*try {
            Thread.sleep(1000); //可能包含数据库连接等耗时操作
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/
        System.out.println("已被创建");
    }
    @Override
    public String request() {
        return "request string";
    }
}

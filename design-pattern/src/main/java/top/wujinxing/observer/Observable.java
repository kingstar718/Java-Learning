package top.wujinxing.observer;



/**
 * @author wujinxing
 * date 2019 2019/8/15 11:24
 * description 1.首先创建一个被观察者抽象接口,创建注册观察者，
 * 取消观察者和提醒所有观察者更新消息的方法，用途是用户订阅、取消订阅和接收消息。
 */
public interface Observable {
    //注册观察者
    void registerObserver(Observer observer);
    //取消观察者
    void removeObserver(Observer observer);
    //通知所有观察者更新消息
    void notifyObserver();
}

package top.wujinxing.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wujinxing
 * date 2019 2019/8/15 11:31
 * description 3.定义被观察者，实现了Observable接口，
 * 对Observable接口的三个方法进行了具体实现，同时有一个List集合，
 * 用以保存注册的观察者，等需要通知观察者时，遍历该集合即可。
 */
public class WeChatServer implements Observable {

    private List<Observer> list;
    private String message;

    public WeChatServer(){
        list = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (!list.isEmpty()) list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (int i=0;i<list.size();i++){
            Observer observer = list.get(i);
            observer.update(message);
        }
    }

    public void setInformation(String s){
        this.message = s;
        System.out.println("公众号推送的消息是：" + s);
        notifyObserver();
    }
}

package top.wujinxing.observer;

/**
 * @author wujinxing
 * date 2019 2019/8/15 11:51
 * description 4.创建具体的观察者，这里具体的观察者也就是用户。
 */
public class User implements Observer{
    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read(){
        System.out.println(name + "接收到推送消息" + message);
    }
}

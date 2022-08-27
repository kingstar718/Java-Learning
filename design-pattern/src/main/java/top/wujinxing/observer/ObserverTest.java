package top.wujinxing.observer;

/**
 * @author wujinxing
 * date 2019 2019/8/15 13:27
 * description 5.接下来就是具体的测试类，假设现在有三个用户订阅了公众号，
 * 公众号发布了一条信息是PHP是世界上最好的语言，此时java开发工程师李四接收到信息后颇为不满，
 * 于是果断取消订阅。
 * 后来公众号又发布了一条信息是：java是世界上最好的语言，此时取消订阅的李四已经接收不到这条信息了。
 */
public class ObserverTest {
    public static void main(String[] args) {
        WeChatServer server = new WeChatServer();

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInformation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        //李四取消订阅
        server.removeObserver(userLi);
        server.setInformation("JAVA是世界上最好用的语言！");
    }
}

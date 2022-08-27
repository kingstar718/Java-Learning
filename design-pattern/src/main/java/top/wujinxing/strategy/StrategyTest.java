package top.wujinxing.strategy;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:37
 * description 测试类
 */
public class StrategyTest {
    public static void main(String[] args) {
        System.out.println("普通游客策略");
        Context context = new Context(new Normal());
        context.buyTicket();

        System.out.println("VIP游客策略");
        context.setTicketStrategy(new VIP());
        context.buyTicket();

        System.out.println("1米2以下儿童策略");
        context.setTicketStrategy(new Children());
        context.buyTicket();
    }
}

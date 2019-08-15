package top.wujinxing.ch_4_designpatterns.strategy;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:30
 * description 2.普通的游客购票
 */
public class Normal implements TicketStrategy {
    @Override
    public void buyTicket() {
        System.out.println("普通游客没有优惠");
    }
}

package top.wujinxing.ch_4_designpatterns.strategy;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:31
 * description 2.1米2以下儿童购票
 */
public class Children implements TicketStrategy{
    @Override
    public void buyTicket() {
        System.out.println("1米2以下儿童享受5折优惠");
    }
}

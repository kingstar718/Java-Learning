package top.wujinxing.strategy;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:31
 * description 2.办理年卡的用户购票
 */
public class VIP implements TicketStrategy{
    @Override
    public void buyTicket() {
        System.out.println("办年卡游客享受8折优惠");
    }
}

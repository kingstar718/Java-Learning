package top.wujinxing.ch_4_designpatterns.proxy.ticketDemo;

/**
 * @author wujinxing
 * date 2019 2019/8/15 9:54
 * description 2.然后创建一个售票服务接口实现类，就好比是车站。
 */
public class Station implements TicketService {
    @Override
    public void sellTicket() {
        System.out.println("售票");
    }

    @Override
    public void Consultation() {
        System.out.println("咨询");
    }

    @Override
    public void ReturnTicket() {
        System.out.println("退票");
    }
}

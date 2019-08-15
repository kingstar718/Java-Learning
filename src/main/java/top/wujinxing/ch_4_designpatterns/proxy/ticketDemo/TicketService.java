package top.wujinxing.ch_4_designpatterns.proxy.ticketDemo;

/**
 * @author wujinxing
 * date 2019 2019/8/15 9:54
 * description 1.首先创建一个售票服务的接口，它有售票咨询和退票的业务可以供客户选择。
 */
public interface TicketService {
    //售票
    void sellTicket();
    //咨询
    void Consultation();
    //退票
    void ReturnTicket();
}

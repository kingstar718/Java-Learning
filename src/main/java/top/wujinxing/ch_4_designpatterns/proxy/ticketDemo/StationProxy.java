package top.wujinxing.ch_4_designpatterns.proxy.ticketDemo;

/**
 * @author wujinxing
 * date 2019 2019/8/15 9:56
 * description 3.然后创建一个代理售票点
 */
public class StationProxy implements TicketService {

    private Station station;

    public StationProxy(Station station){
        this.station = station;
    }

    @Override
    public void sellTicket() {
        System.out.println("欢迎使用车票代售点进行购票，每张票将会收取5元手续费！");
        station.sellTicket();
        System.out.println("欢迎下次光临");
    }

    @Override
    public void Consultation() {
        System.out.println("欢迎咨询，咨询不收取费用");
        station.Consultation();
        System.out.println("欢迎下次光临");
    }

    @Override
    public void ReturnTicket() {
        System.out.println("欢迎使用车票代售点进行退票，每张票将会收取5元手续费！");
        station.ReturnTicket();
        System.out.println("欢迎下次光临");
    }
}

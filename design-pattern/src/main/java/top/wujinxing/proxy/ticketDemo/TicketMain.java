package top.wujinxing.proxy.ticketDemo;

/**
 * @author wujinxing
 * date 2019 2019/8/15 9:58
 * description 4.创建购买车票的角色,去代理点完成购买车票的需求
 */
public class TicketMain {
    public static void main(String[] args) {
        Station station = new Station();
        StationProxy stationProxy1 = new StationProxy(station);
        StationProxy stationProxy2 = new StationProxy(station);
        stationProxy1.sellTicket();
        stationProxy2.Consultation();
    }
}

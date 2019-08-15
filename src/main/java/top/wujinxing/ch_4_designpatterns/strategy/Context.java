package top.wujinxing.ch_4_designpatterns.strategy;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:34
 * description 3.创建上下文类。
 */
public class Context {

    private TicketStrategy ticketStrategy;

    public Context(TicketStrategy ticketStrategy){
        this.ticketStrategy = ticketStrategy;
    }

    public void setTicketStrategy(TicketStrategy ticketStrategy){
        this.ticketStrategy = ticketStrategy;
    }

    public void buyTicket(){
        this.ticketStrategy.buyTicket();
    }
}

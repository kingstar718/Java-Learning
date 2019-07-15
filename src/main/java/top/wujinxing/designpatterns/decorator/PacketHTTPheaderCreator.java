package top.wujinxing.designpatterns.decorator;

/**
 * @author: wujinxing
 * @date: 2019/3/25 17:27
 * @description:  完成数据包HTTP拖布的处理, 其余业务依然交由内部的component完成
 */
public class PacketHTTPheaderCreator extends PacketDecorator {
    public PacketHTTPheaderCreator(IPacketCreator c) {
        super(c);
    }

    @Override
    public String handleContent() { //对给定数据加上HTTP头信息
        StringBuffer sb = new StringBuffer();
        sb.append("Cache-Control:no-cache\n");
        sb.append("Date:Mon, 31Dec201204:25:57GMT\n");
        sb.append(component.handleContent());

        return sb.toString();
    }
}

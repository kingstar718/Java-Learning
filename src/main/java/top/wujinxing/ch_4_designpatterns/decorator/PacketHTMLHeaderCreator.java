package top.wujinxing.ch_4_designpatterns.decorator;

/**
 * @author: wujinxing
 * @date: 2019/3/25 17:19
 * @description: 具体的装饰器, 负责对核心发布的内容进行HTML格式化操作,
 * 需要注意的是: 它委托了具体组件component进行核心业务处理
 */
public class PacketHTMLHeaderCreator extends PacketDecorator {
    public PacketHTMLHeaderCreator(IPacketCreator c) {
        super(c);
    }

    @Override
    public String handleContent() { //将给定的数据封装成HTML
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(component.handleContent());
        sb.append("</body>");
        sb.append("</html>");
        sb.append("<html>");

        return sb.toString();
    }
}

package top.wujinxing.designpatterns.decorator;

/**
 * @author: wujinxing
 * @date: 2019/3/25 17:31
 * @description: 使用方法
 */
public class DecoratorMain {
    public static void main(String[] args){
        IPacketCreator pc = new PacketHTTPheaderCreator(
                                new PacketHTMLHeaderCreator(
                                new PacketBodyCreate()));
        System.out.println(pc.handleContent());
    }
    //先由PacketBodyCreate对象去生成核心发布内容,
    //接着由PacketHTMLHeaderCreator对象对这个内容进行处理,将其转化为HTML
    //最后由PacketHTTPheaderCreator对上面函数的输出安置HTTP头部.
}

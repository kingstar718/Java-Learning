package top.wujinxing.decorator;

/**
 * @author: wujinxing
 * @date: 2019/3/25 17:13
 * @description:  用于返回数据包的核心数据
 */
public class PacketBodyCreate implements IPacketCreator {

    @Override
    public String handleContent() {
        return "Content of Packet";  //构造核心数据, 但不包括格式
    }
}

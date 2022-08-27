package top.wujinxing.decorator;

/**
 * @author: wujinxing
 * @date: 2019/3/25 17:16
 * @description: 维护核心组件component对象
 * 负责告知其子类, 其核心业务逻辑应该全权委托component完成,自己仅仅是左增强处理
 */
public abstract class PacketDecorator implements IPacketCreator {
    IPacketCreator component;

    public PacketDecorator(IPacketCreator c) {
        component = c;
    }
}

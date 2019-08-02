package top.wujinxing.ch_4_designpatterns.decorator;

/**
 * @author: wujinxing
 * @date: 2019/3/25 17:12
 * @description: 装饰接口, 用于处理躯体的内容
 */
public interface IPacketCreator {
    public String handleContent();  //用于内容处理
}

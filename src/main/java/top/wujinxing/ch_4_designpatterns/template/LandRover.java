package top.wujinxing.ch_4_designpatterns.template;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:56
 * description 2.然后创建一个造路虎车的子类，用这个子类去继承造车的公有模块类CarTemplate。然后在方法中完善造路虎车特有的功能
 */
public class LandRover extends CarTemplate{

    protected LandRover(String name) {
        super(name);
    }

    @Override
    protected void buildWheel() {
        System.out.println(name + "越野车轮");
    }

    @Override
    protected void buildEngine() {
        System.out.println(name + "柴油发动机");
    }

    @Override
    protected void buildCarbody() {
        System.out.println(name + "SUV越野车型");
    }

    @Override
    protected void buildCarlight() {
        System.out.println(name + "普通车灯");
    }
}

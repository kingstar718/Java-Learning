package top.wujinxing.ch_4_designpatterns.template;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:57
 * description 2.再创建一个造奥迪的子类，同样用这个子类继承模板类，并完善造奥迪的方法，
 */
public class Audi extends CarTemplate {

    protected Audi(String name) {
        super(name);
    }

    @Override
    protected void buildWheel() {
        System.out.println(name + "的普通轿车车轮");
    }

    @Override
    protected void buildEngine() {
        System.out.println(name + "的汽油发动机");
    }

    @Override
    protected void buildCarbody() {
        System.out.println(name + "的豪华舒适性车身");
    }

    @Override
    protected void buildCarlight() {
        System.out.println(name + "的独特魔力车灯");
    }
}

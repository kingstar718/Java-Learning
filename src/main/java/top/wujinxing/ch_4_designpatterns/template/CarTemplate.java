package top.wujinxing.ch_4_designpatterns.template;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:53
 * description 1.首先需要创建一个模板抽象父类，将造车需要的模块创建好。
 */
public abstract class CarTemplate {
    protected String name;

    protected CarTemplate(String name){
        this.name = name;
    }

    protected abstract void buildWheel();

    protected abstract void buildEngine();

    protected abstract void buildCarbody();

    protected abstract void buildCarlight();

    public final void buildCar(){
        buildWheel();
        buildEngine();
        buildCarbody();
        buildCarlight();
    }
}

package top.wujinxing.template;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:58
 * description 所有步骤都已完成，奥迪和路虎车运用统一模板，但是通过在子类中完善各自不同的方法而达到目的
 */
public class TemplateTest {
    public static void main(String[] args) {
        CarTemplate car1 = new LandRover("路虎");
        CarTemplate car2 = new Audi("奥迪");
        car1.buildCar();
        car2.buildCar();
    }
}

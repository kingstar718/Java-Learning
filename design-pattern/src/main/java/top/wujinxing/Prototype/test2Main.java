package top.wujinxing.Prototype;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:47
 * description
 */
public class test2Main {
    public static void main(String[] args) {
        //原型A对象
        test2Resume a = new test2Resume("闫猪头");
        a.setPersonInfo("2.16", "男", "家里蹲大学");
        a.setWorkExperience("2018.09.05", "搬砖工地");

        //克隆B对象
        test2Resume b = (test2Resume) a.clone();

        //输出A和B对象
        System.out.println("----------------A--------------");
        a.display();
        System.out.println("----------------B--------------");
        b.display();

        /*
         * 测试A==B?
         * 对任何的对象x，都有x.clone() !=x，即克隆对象与原对象不是同一个对象
         */
        System.out.print("A==B?");
        System.out.println( a == b);

        /*
         * 对任何的对象x，都有x.clone().getClass()==x.getClass()，即克隆对象与原对象的类型一样。
         */
        System.out.print("A.getClass()==B.getClass()?");
        System.out.println(a.getClass() == b.getClass());
    }
}

package top.wujinxing.ch_2_basicjava.reflection;

/**
 * @author wujinxing
 * date 2019 2019/5/13 10:03
 * description 编译器将检查类型向下转型是否合法，如果不合法将抛出异常。向下转换类型前，可以使用instanceof判断。
 */
public class typeConversion {
    public static void main(String[] args) {
        Base base = new Derived();
        //instanceof判断
        if (base instanceof Derived){
            System.out.println("ok");
        }else {
            System.out.println("not ok");
        }
    }
}
class Derived extends Base{}

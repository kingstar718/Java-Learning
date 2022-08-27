package top.wujinxing.copy;

/**
 * @author wujinxing
 * date 2019 2019/7/3 9:56
 * description  new与clone()
 */
public class cloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person("wu", 25);
        Person p1 = p;
        Person p2 = (Person) p.clone();
        System.out.println(p + " " + p1 + " " + p2);
        //top.wujinxing.copy.Person@76ed5528
        //top.wujinxing.copy.Person@76ed5528  指向原有对象
        //top.wujinxing.copy.Person@2c7b84de  创建新对象
        String result = p.getName() == p1.getName()? "clone为浅拷贝":"clone为深拷贝";
        System.out.println(result); //浅拷贝。String类型的name实际上是同一个对象
        System.out.println(p.hashCode()+" "+p1.hashCode()+" "+p2.hashCode());
    }

}

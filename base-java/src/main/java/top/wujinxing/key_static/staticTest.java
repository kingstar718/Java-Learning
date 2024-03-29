package top.wujinxing.key_static;

/**
 * @author: wujinxing
 * @date: 2019/2/23 15:28
 * @description:
 */
public class staticTest {
    private static String name = "kingstar";
    private String num = "X001";

    static class Person{    //静态内部类可以用public，protected，private修饰
        //静态内部类中可以定义静态或者非静态的成员
        private String address = "China";
        private static String x = "Wuhan";
        public String mail = "kingstar718@foxmail.com";   //内部类公有成员

        public void display(){
            //System.out.println(num);//不能直接访问外部类的非静态成员
            // 静态内部类不能访问外部类的非静态成员(包括非静态变量和非静态方法)
            System.out.println(name);//只能直接访问外部类的静态成员
            //静态内部类只能访问外部类的静态成员(包括静态变量和静态方法)
            System.out.println("Inner " + address);//访问本内部类成员。
        }
    }

    public void printInfo(){
        // 外部类访问内部类的非静态成员:实例化内部类即可
        Person person = new Person();

        person.display();
        //System.out.println(mail);   //不可访问
        //System.out.println(address);    //不可访问
        System.out.println(person.address); //可以访问内部类的私有成员

        System.out.println(Person.x);   // 外部类访问内部类的静态成员：内部类.静态成员
        System.out.println(person.mail);    //可以访问内部类的公有成员
    }

    public static void main(String[] args){
        staticTest staticTest = new staticTest();
        staticTest.printInfo();
    }
}

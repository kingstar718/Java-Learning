package top.wujinxing.polymorphism;

/**
 * @author 01397208
 * @date 2025/12/31
 */
public class PolymorphismTest3 {

    public static void main(String[] args) {
        Super super1 = new Super();
        Super super2 = new Sub();
        Sub sub = new Sub();
        // 成员变量没有继承关系，所以不能通过子类对象访问父类成员变量
        System.out.println(super1.x); // 1
        System.out.println(super2.x); // 1
        System.out.println(sub.x); // 2
    }

    static class Super {
        int x = 1;
    }

    static class Sub extends Super {
        int x = 2;
    }

}

package top.wujinxing.polymorphism;

/**
 * @author wujinxing
 * @date 2019/2/18 15:24
 * 运行时多态
 * 1、继承或实现
 * 2、方法重写：子类必须重写父类的方法。
 * 3、向上转型：父类引用指向子类对象：Employee employee = new Manager();
 */
public class PolymorphismTest1 {

    public static void main(String[] args) {
        Employee employee;
        employee = new Manager();
        // Manager
        System.out.println(employee.getClass().getName());
        // I am a manager.
        employee.work();
        Manager manager = (Manager) employee;
        // I am a manager.
        manager.work();
    }


    static class Employee {
        public void work() {
            System.out.println("I am an employee.");
        }
    }


    static class Manager extends Employee {
        @Override
        public void work() {
            System.out.println("I am a manager.");
        }

        public void manage() {
            System.out.println("Manage...");
        }
    }

}
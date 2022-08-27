package top.wujinxing.polymorphism;

/**
 * @author: wujinxing
 * @date: 2019/2/18 15:24
 * @description:多态
 */
public class PloymorphismTest1 {
    public static void main(String[] args){
        Employee employee;
        employee = new Manager();
        System.out.println(employee.getClass().getName());//Manager
        employee.work();    //I am a manager.
        Manager manager = (Manager) employee;
        manager.work(); //I am a manager.
    }
}

class Employee{
    public void work(){
        System.out.println("I am an employee.");
    }
}

class Manager extends Employee {
    @Override
    public void work() {
        System.out.println("I am a manager.");
    }
    public void manage(){
        System.out.println("Manage...");
    }
}
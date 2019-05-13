package top.wujinxing.reflection;

import java.io.Serializable;

/**
 * @author wujinxing
 * date 2019 2019/5/13 9:34
 * description  class
 *
 * 类的加载器将class文件加载到虚拟机中(内存中),
 * 那么有一个class对象, (代表class文件加载到内存后所形成的的一个对象)
 *
 * 反射第一步获得class文件加载到内存的形成字节码文件的对象Class对象
 */
public class Person implements Serializable {
    //Constructor
    public Person(){
        super();
    }
    public Person(String name, Integer age){
        super();
        this.name = name;
        this.age = age;
    }
    //Field
    private String name;
    private Integer age;

    //Method
    public void run(){
        System.out.println("run...");
    }
    public String sayHello(String name){
        return "Hello " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

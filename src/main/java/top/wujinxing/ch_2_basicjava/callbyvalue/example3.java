package top.wujinxing.ch_2_basicjava.callbyvalue;

/**
 * @author: wujinxing
 * @date: 2019/3/29 14:22
 * @description:
 */
public class example3 {

    public static void main(String[] args) {
        Student s1 = new Student("小李");
        Student s2 = new Student("小张");

        example3.swap(s1, s2);

        System.out.println("s1: " + s1.getName());
        System.out.println("s2: " + s2.getName());
    }

    public static void swap(Student x, Student y) {
        Student temp = x;
        x = y;
        y = temp;

        System.out.println("x: " + x.getName());
        System.out.println("y: " + y.getName());

        /**
         * 方法并没有改变存储在变量 s1 和 s2 中的对象引用。
         * swap方法的参数x和y被初始化为两个对象引用的拷贝，这个方法交换的是这两个拷贝
         */
    }
}

class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package top.wujinxing.Copy;

//import org.apache.commons.beanutils.BeanUtils;

/**
 * @author: wujinxing
 * @date: 2019/1/14 14:32
 * @description:
 */
class Address implements Cloneable{
    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    protected Object clone(){
        Address addr = null;
        try{
            addr = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return addr;
    }
}

class Student implements Cloneable{
    private int number;
    private Address address;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Object clone(){
        Student stu = null;
        try{
            stu = (Student) super.clone();//浅克隆
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        stu.address = (Address) address.clone();//深克隆
        return stu;
    }
}


public class Test {
    public static void main(String[] args){
        Student stu1 = new Student();
        stu1.setNumber(12345);
        Student stu2 = stu1;    //将stu1的引用赋值给stu2，这样，stu1，stu2指向堆内存的同一个对象s
        stu1.setNumber(54321);
        System.out.println("Student1：" + stu1.getNumber() + " stu1的地址：" + stu1);
        System.out.println("Student2：" + stu2.getNumber() + " stu2的地址：" + stu2);

        //如何干干净净的复制一个对象
        //1.将A对象的值通过set方法加入到B中
        Student stu3 = new Student();
        stu3.setNumber(6789);
        Student stu4 = new Student();
        stu4.setNumber(stu3.getNumber());
        System.out.println("Student3：" + stu3.getNumber() + " stu3的地址：" + stu3);
        System.out.println("Student4：" + stu4.getNumber() + " stu4的地址：" + stu4);


        //2.通过重写java.lang.object中的clone()方法；
            //a.实现Cloneable接口
            //b.重写clone方法，并将访问修饰符改为public
        /*Student stu5 = new Student();
        stu5.setNumber(1122);
        Student stu6 = (Student) stu5.clone();
        stu5.setNumber(2333);
        System.out.println("Student5：" + stu5.getNumber() + " stu5的地址：" + stu5);
        System.out.println("Student6：" + stu6.getNumber() + " stu6的地址：" + stu6);*/

        Address address = new Address();
        address.setAdd("武汉市");
        Student stu7 = new Student();
        stu7.setNumber(1);
        stu7.setAddress(address);
        Student stu8 = (Student) stu7.clone();
        System.out.println("Student7：" + stu7.getNumber() + " stu7的地址：" + stu7.getAddress().getAdd());
        System.out.println("Student8：" + stu8.getNumber() + " stu8的地址：" + stu8.getAddress().getAdd());
        address.setAdd("西湖");

        System.out.println("Student7：" + stu7.getNumber() + " stu7的地址：" + stu7.getAddress().getAdd());
        System.out.println("Student8：" + stu8.getNumber() + " stu8的地址：" + stu8.getAddress().getAdd());

        //3.通过org.apache.commons中的工具类BeanUtils和PropertyUtils进行对象复制
        Student stu9 = new Student();
        stu9.setNumber(123);
        stu9.setAddress(address);
        Student stu10 = new Student();
        /*try {
            BeanUtils.copyProperties(stu10,stu9);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/
        System.out.println("Student7：" + stu9.getNumber() + " stu9的地址：" + stu9.getAddress().getAdd());
        System.out.println("Student8：" + stu8.getNumber() + " stu10的地址：" + stu10.getAddress().getAdd());
        //4.通过序列化实现兑现的复制
    }
}

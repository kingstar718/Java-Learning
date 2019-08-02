package top.wujinxing.ch_2_basicjava.java8;

/**
 * @author: wujinxing
 * @date: 2019/3/16 21:17
 * @description:
 */
public class Test4_method_Constructor {
    //Java 8 允许你通过::关键字获取方法或者构造函数的的引用。
    // 上面的例子就演示了如何引用一个静态方法。
    // 而且，我们还可以对一个对象的方法进行引用：
    public static void main(String[] args){
        /*Something something = new Something();
        Converter<String, Integer> converter = something::statsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);*/


        //通过构造函数引用来把所有东西拼到一起，而不是像以前一样，通过手动实现一个工厂来这么做
        PersonFactory<Person> personPersonFactory = Person::new;
        Person person = personPersonFactory.create("Peter","Parker");
        System.out.println(person.firstName+" "+person.lastName);
    }
}

class Something{
    String statsWith(String s){
        return String.valueOf(s.charAt(0));
    }
}

class Person{
    String firstName;
    String lastName;
    Person(){};
    Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

//定义一个person工厂接口，用来创建新的person对象：
interface PersonFactory<P extends Person>{
    P create(String firstName, String lastName);
}

package top.wujinxing.java8;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author: wujinxing
 * @date: 2019/3/17 20:32
 * @description:
 */
public class Test6_FunctionalInterface {

    public static void main(String[] args){
        //Predicate是一个布尔类型的函数，该函数只有一个输入参数。
        // Predicate接口包含了多种默认方法，用于处理复杂的逻辑动词（and, or，negate）
        Predicate<String> predicate = (s)->s.length()>0;
        System.out.println(predicate.test("foo"));
        System.out.println(predicate.negate().test("foo"));

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        //Function接口接收一个参数，并返回单一的结果。默认方法可以将多个函数串在一起（compse, andThen）
        //Java 8 允许你通过::关键字获取方法或者构造函数的的引用
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString  =toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("123"));

        //Supplier接口产生一个给定类型的结果。与Function不同的是，Supplier没有输入参数。
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();//new Person

        //Consumer代表了在一个输入参数上需要进行的操作
        Consumer<Person> greeter = p->System.out.println("Hello" + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));

        //Comparator接口在早期的Java版本中非常著名。Java 8 为这个接口添加了不同的默认方法。
        Comparator<Person> comparator = (p1,p2)->p1.firstName.compareTo(p2.firstName);
        Person p1 = new Person("Jhon","Doe");
        Person p2 = new Person("Alice","Wonderland");

        System.out.println(comparator.compare(p1,p2)); //>0
        System.out.println(comparator.reversed().compare(p1,p2));//<0

        //Optional不是一个函数式接口，而是一个精巧的工具接口，
        // 用来防止NullPointerEception产生。这个概念在下一节会显得很重要，
        // 所以我们在这里快速地浏览一下Optional的工作原理。
        //
        //Optional是一个简单的值容器，这个值可以是null，
        // 也可以是non-null。考虑到一个方法可能会返回一个non-null的值，
        // 也可能返回一个空值。为了不直接返回null，我们在Java 8中就返回一个Optional。
        Optional<String> optional = Optional.of("ban");
        System.out.println(optional.isPresent()); //true
        System.out.println(optional.get());     //"ban"
        System.out.println(optional.orElse("fallback"));    //ban
        optional.ifPresent(s -> System.out.println(s.charAt(0)));//b
    }

}

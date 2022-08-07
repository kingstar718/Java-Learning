package top.wujinxing.ch_2_basicjava.java8;

import lombok.extern.slf4j.Slf4j;

/**
 * Java 8 允许你通过::关键字获取方法或者构造函数的的引用
 * 还可以对一个对象的方法进行引用
 *
 * @author wujinxing
 * @date 2019/3/16 21:17
 */
@Slf4j
public class MethodConstructor {

    public static void main(String[] args) {

        //通过构造函数引用来把所有东西拼到一起，而不是像以前一样，通过手动实现一个工厂来这么做
        PersonFactory<Person> personPersonFactory = Person::new;
        Person person = personPersonFactory.create("Peter", "Parker");
        log.info("person: {}", person);

    }

    /**
     * 定义一个person工厂接口，用来创建新的person对象
     */
    interface PersonFactory<P extends Person> {
        /**
         * 对象创建
         *
         * @param firstName /
         * @param lastName  /
         * @return P
         */
        P create(String firstName, String lastName);
    }
}





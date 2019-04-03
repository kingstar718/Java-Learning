package top.wujinxing.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: wujinxing
 * @date: 2019/3/17 21:46
 * @description:
 * java.util.Stream表示了某一种元素的序列，
 * 在这些元素上可以进行各种操作。Stream操作可以是中间操作，也可以是完结操作。
 * 完结操作会返回一个某种类型的值，而中间操作会返回流对象本身，
 * 并且你可以通过多次调用同一个流操作方法来将操作结果串起来
 * （就像StringBuffer的append方法一样————译者注）。
 * Stream是在一个源的基础上创建出来的，
 * 例如java.util.Collection中的list或者set（map不能作为Stream的源）。
 * Stream操作往往可以通过顺序或者并行两种方式来执行。
 */
public class Test7_Streams {
    public static void main(String[] args){
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");

        //Java 8中的Collections类的功能已经有所增强，
        // 你可以之直接通过调用Collections.stream()
        // 或者Collection.parallelStream()方法来创建一个流对象。下面的章节会解释这个最常用的操作。

        //Filter接受一个predicate接口类型的变量，并将所有流对象中的元素进行过滤。
        // 该操作是一个中间操作，因此它允许我们在返回结果的基础上再进行其他的流操作（forEach）。
        // ForEach接受一个function接口类型的变量，用来执行对每一个元素的操作。
        // ForEach是一个中止操作。它不返回流，所以我们不能再调用其他的流操作。
        stringList
                .stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);//aaa2 aaa1

        //Sorted是一个中间操作，能够返回一个排过序的流对象的视图。
        //流对象中的元素会默认按照自然顺序进行排序，除非你自己指定一个Comparator接口来改变排序规则。
        stringList
                .stream()
                .sorted()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println); //aaa1 aaa2

        System.out.println(stringList);//[ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1]

        /*map是一个对于流对象的中间操作，通过给定的方法，
        它能够把流对象中的每一个元素对应到另外一个对象上。
        下面的例子就演示了如何把每个string都转换成大写的string。
        不但如此，你还可以把每一种对象映射成为其他类型。
        对于带泛型结果的流对象，具体的类型还要由传递给map的泛型方法来决定。*/
        stringList
                .stream()
                .map(String::toUpperCase)
                .sorted((a,b)->b.compareTo(a))
                .forEach(System.out::println);
        // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"

        /*Match
        匹配操作有多种不同的类型，都是用来判断某一种规则是否与流对象相互吻合的。
        所有的匹配操作都是终结操作，只返回一个boolean类型的结果。*/
        boolean anyStartsWithA =
                stringList
                    .stream()
                .anyMatch(s->s.startsWith("a")); //true
        System.out.println(anyStartsWithA);

        boolean allStatrtsWithA =
                stringList
                    .stream()
                .allMatch(s->s.startsWith("a"));
        System.out.println(allStatrtsWithA);    //false

        boolean noneStartsWithZ =
                stringList
                    .stream()
                .noneMatch(s->s.startsWith("z"));
        System.out.println(noneStartsWithZ); //true;


        /*Count
        Count是一个终结操作，它的作用是返回一个数值，用来标识当前流对象中包含的元素数量。*/
        long startWithB =
                stringList
                    .stream()
                .filter(s->s.startsWith("b"))
                .count();
        System.out.println(startWithB);//3

        /*Reduce
        该操作是一个终结操作，它能够通过某一个方法，对元素进行削减操作。
        该操作的结果会放在一个Optional变量里返回。*/
        Optional<String> reduced =
                stringList
                    .stream()
                    .sorted()
                    .reduce((s1,s2)->s1+"#"+s2);
        reduced.ifPresent(System.out::printf);//aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2



    }

}

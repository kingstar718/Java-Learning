package top.wujinxing.java11;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinxing
 * @date 2023/3/8
 */
@Slf4j
public class Ch3Collections {

    public static void main(String[] args) {
        List<String> list = List.of("Java", "Python", "C");
        var copy = List.copyOf(list);
        var equal = list == copy;
        log.info("list copy equal: {}", equal);

        List<String> list2 = new ArrayList<>();
        List<String> copy2 = List.copyOf(list);
        log.info("list2 copy2 equal: {}", list2 == copy2);

        // copyOf 方法会先判断来源集合是不是 AbstractImmutableList 类型的，
        // 如果是，就直接返回，如果不是，则调用 of 创建一个新的集合。

        //示例2因为用的 new 创建的集合，不属于不可变 AbstractImmutableList 类的子类，
        // 所以 copyOf 方法又创建了一个新的实例，所以为false.

    }

}

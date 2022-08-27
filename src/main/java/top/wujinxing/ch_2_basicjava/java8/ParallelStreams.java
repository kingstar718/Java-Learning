package top.wujinxing.ch_2_basicjava.java8;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author wujinxing
 * @date 2019/3/17 22:20
 * 像上面所说的，流操作可以是顺序的，也可以是并行的。
 * 顺序操作通过单线程执行，而并行操作则通过多线程执行。
 * <p>
 * 下面的例子就演示了如何使用并行流进行操作来提高运行效率，代码非常简单。
 */
public class ParallelStreams {

    public static void main(String[] args) {

        int max = 1000000;
        List<String> values = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();

        //long count = values.stream().sorted().count();
        long count = values.parallelStream().sorted().count();

        System.out.println(count);

        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis((t1 - t0));
        //System.out.println(String.format("sequential sort took :%d ms", millis));//sequential sort took :705 ms
        System.out.println(String.format("parallel sort took :%d ms", millis));//parallel sort took :407 ms


        // 正如前面已经提到的那样，map是不支持流操作的。
        // 而更新后的map现在则支持多种实用的新方法，来完成常规的任务。

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            // putIfAbsent避免我们将null写入；
            map.putIfAbsent(i, "val" + i);
        }

        // forEach接受一个消费者对象，从而将操作实施到每一个map中的值上。
        map.forEach((id, val) -> System.out.println(val));

        //下面的这个例子展示了如何使用函数来计算map的编码：
        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3); //val33
        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);//false
        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);//true
        map.computeIfAbsent(3, num -> "ban");
        map.get(3); //val33

        //当给定一个key值时，如何把一个实例从对应的key中移除
        map.remove(3, "val3");
        map.get(3);             // val33

        map.remove(3, "val33");
        map.get(3);             // null

        map.getOrDefault(42, "not found");  // not found

        //将map中的实例合并也是非常容易的
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9concat
        //合并操作先看map中是否没有特定的key/value存在，
        //如果是，则把key/value存入map，否则merging函数就会被调用，对现有的数值进行修改。
    }
}

package top.wujinxing.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author 01397208
 * @date 2023/12/8
 */
@Slf4j
public class StringDemo {

    public static void main(String[] args) {

        // Joiner
        Joiner joiner = Joiner.on("; ").skipNulls();
        String join = joiner.join("Harry", null, "Ron", "Hermione");
        log.info("join: {}", join);
        // 连接对象类型，会把对象的toString值连接
        log.info("join object: {}", Joiner.on(",").join(Arrays.asList(1, 2, 3)));

        // Splitter
        String[] split = ",a,,b,".split(",");
        // 只有尾部的空字符被忽略了：返回的是 "","a","","b"
        log.info("原生：{}", Arrays.toString(split));

        Iterable<String> strings = Splitter
                .on(',')
                // 移除结果字符串的前导空白和尾部空白
                .trimResults()
                // 从结果中自动忽略空字符串
                .omitEmptyStrings()
                .split("foo,bar,,   qux");
        strings.forEach(log::info);


        // CharMatcher
        log.info("移除control字符：{}", CharMatcher.javaIsoControl().removeFrom(""));
        log.info("只保留数字字符：{}", CharMatcher.digit().retainFrom("123*fds903fds4"));
        log.info("去除两端空格，并将中间的连续空格替换为单个空格：{}", CharMatcher.whitespace().trimAndCollapseFrom("  fdsfsa   fdsafsd fsd   ", ' '));
        log.info("用*号替换所有数字：{}", CharMatcher.javaDigit().replaceFrom("342fdfsa34fdw49i", '*'));
        log.info("只保留数字和小写字母：{}", CharMatcher.javaDigit().or(CharMatcher.javaLowerCase()).retainFrom("JAVA123javaGo"));
        
    }

}

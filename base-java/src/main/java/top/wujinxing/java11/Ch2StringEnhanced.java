package top.wujinxing.java11;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wujinxing
 * @date 2022-09-24
 */
@Slf4j
public class Ch2StringEnhanced {

    public static void main(String[] args) {
        String blank = "    ";

        // 字符串判空
        var bool = blank.isBlank();
        log.info("blank: {}", bool);

        // 分割获取字符串流
        var lines = "a\nb\nc";
        var streamLine = lines.lines();
        streamLine.forEach(s -> log.info("line:{}", s));
        log.info("line count:{}", lines.lines().count());

        // 复制字符串
        var repeat = "repeat;";
        var repeat3 = repeat.repeat(3);
        log.info("repeat3:{}", repeat3);

        // 去除空格
        String strip = "   　 https://www.wdbyte.com 　";
        log.info("1=={}==", strip.strip());
        log.info("2=={}==", strip.stripTrailing());
        log.info("3=={}==", strip.stripLeading());
        // trim只能去除半角空格，strip可以去除各种空白字符
        log.info("4=={}==", strip.trim());

    }

}

package top.wujinxing.java8;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;


/**
 * @author wujinxing
 * @date 2019/3/18 08:57
 */
@Slf4j
public class TimeApi {

    public static void main(String[] args) {

        // Clock
        // Clock提供了对当前时间和日期的访问功能。
        // Clock是对当前时区敏感的，并可用于替代System.currentTimeMillis()方法来获取当前的毫秒时间。
        // 当前时间线上的时刻可以用Instance类来表示。
        // Instance也能够用于创建原先的java.util.Date对象。
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        log.info("clock millis: {}", millis);
        Instant instant = clock.instant();
        Date instantDate = Date.from(instant);
        log.info("instant date: {}", instantDate);


        // Timezones
        // 时区类可以用一个ZoneId来表示。时区类的对象可以通过静态工厂方法方便地获取。
        // 时区类还定义了一个偏移量，用来在当前时刻或某时间与目标时区时间之间进行转换。
        // prints all available timezone ids
        log.info("getAvailableZoneIds: {}", ZoneId.getAvailableZoneIds());
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        log.info("zone1 getRules: {}", zone1.getRules());
        //ZoneRules[currentStandardOffset=+01:00]
        log.info("zone2 getRules: {}", zone2.getRules());
        //ZoneRules[currentStandardOffset=-03:00]


        // LocalTime
        // 本地时间类表示一个没有指定时区的时间，例如，10p.m.或者17：30:15，
        // 下面的例子会用上面的例子定义的时区创建两个本地时间对象。
        // 然后我们会比较两个时间，并计算它们之间的小时和分钟的不同。
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        log.info("now1.isBefore(now2): {}", now1.isBefore(now2));

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        log.info("hoursBetween: {}", hoursBetween);
        log.info("minutesBetween: {}", minutesBetween);

        LocalTime late = LocalTime.of(23, 59, 59);
        log.info("LocalDate.of(23, 59, 59): {}", late);

        //对时间字符串进行解析的操作
        DateTimeFormatter germanFormatter =
                DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);
        LocalTime formatTime = LocalTime.parse("13:37", germanFormatter);
        log.info("formatTime: {}", formatTime);


        // LocalDate
        // 本地时间表示了一个独一无二的时间，例如：2014-03-11。
        // 这个时间是不可变的，与LocalTime是同源的。
        // 下面的例子演示了如何通过加减日，月，年等指标来计算新的日期。
        // 记住，每一次操作都会返回一个新的时间对象。
        LocalDate today = LocalDate.now();
        log.info("today localDate: {}", today);
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        log.info("yesterday localDate: {}", yesterday);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        log.info("dayOfWeek: {}", dayOfWeek);

        //解析字符串并形成LocalDate对象，
        DateTimeFormatter germanFormatter1 =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter1);
        log.info("xmas: {}", xmas);

        // @LocalDateTime
        // LocalDateTime表示的是日期-时间。
        // 它将刚才介绍的日期对象和时间对象结合起来，形成了一个对象实例。
        // LocalDateTime是不可变的，与LocalTime和LocalDate的工作原理相同。
        //我们可以通过调用方法来获取日期时间对象中特定的数据域。
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek1 = sylvester.getDayOfWeek();
        log.info("dayOfWeek1: {}", dayOfWeek1);
        // WEDNESDAY  得到周几

        Month month = sylvester.getMonth();
        log.info("month: {}", month);
        // DECEBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        log.info("minuteOfDay: {}", minuteOfDay);
        //1439 一天的分钟数

        // 如果再加上的时区信息，LocalDateTime能够被转换成Instance实例。
        // Instance能够被转换成以前的java.util.Date对象。
        Instant instant1 = sylvester.atZone(ZoneId.systemDefault()).toInstant();

        Date legacyDate1 = Date.from(instant1);
        log.info("legacyDate1: {}", legacyDate1);

        // 格式化日期-时间对象就和格式化日期对象或者时间对象一样。
        // 除了使用预定义的格式以外，我们还可以创建自定义的格式化对象，然后匹配我们自定义的格式。
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM dd yyyy - HH:mm");
        LocalDateTime parsed1 = LocalDateTime.parse("12 03 2014 - 07:12", formatter1);
        String string = formatter1.format(parsed1);
        log.info("format string: {}", string);

    }
}

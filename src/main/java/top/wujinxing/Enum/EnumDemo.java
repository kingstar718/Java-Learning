package top.wujinxing.Enum;

/**
 * @author: wujinxing
 * @date: 2019/2/23 15:00
 * @description:
 */
public class EnumDemo {

    public static void main(String[] args){
        Day day = Day.MONDAY;
        System.out.println(day);
    }

    /**
     * 枚举类
     */
    enum Day{
        MONDAY,TUESDAY,WEDENSDAY,
        THURSDAY,FRIDAY,SATURDAY,SUNDAY
    }
}

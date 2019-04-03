package top.wujinxing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: wujinxing
 * @date: 2019/1/3 13:40
 * @description:
 */
public class ch04Date {
    public static void main(String[] args){
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            Date date = format.parse("12/31/2011");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(format.format(new Date()));
        System.out.println(new Date());
    }
}

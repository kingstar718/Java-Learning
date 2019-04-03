package top.wujinxing;

import org.junit.Test;

import java.util.Calendar;

/**
 * @author: wujinxing
 * @date: 2019/1/2 20:19
 * @description:
 */
public class ch02Formatter {
    public static void formatter(){
        String firstName = "John";
        String lastName = "Adams";
        System.out.format("First Name: %s. and Last Name:  %s.",firstName,lastName);

        // Writes a formatted string to System.out.
        System.out.format("Local time: %tT", Calendar.getInstance());
    }

    @Test
    public void test(){
        formatter();
    }
}

package top.wujinxing.basictype;
import java.util.Calendar;

/**
 * @author wujinxing
 * date: 2019/1/2 20:19
 * description: format的使用
 */
public class ch_02_Formatter {
    public static void main(String[] args) {
        formatter();
    }
    private static void formatter(){
        String firstName = "John";
        String lastName = "Adams";
        System.out.format("First Name: %s. and Last Name:  %s.",firstName,lastName);
        System.out.println();
        System.out.println(String.format("First Name: %s. and Last Name:  %s.", firstName, lastName));

        // Writes a formatted string to System.out.
        System.out.format("Local time: %tT", Calendar.getInstance());
    }
}

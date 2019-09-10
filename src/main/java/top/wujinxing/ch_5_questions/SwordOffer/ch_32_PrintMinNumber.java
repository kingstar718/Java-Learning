package top.wujinxing.ch_5_questions.SwordOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author wujinxing
 * date 2019 2019/9/10 23:24
 * description 把数组排成最小的数
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 */
public class ch_32_PrintMinNumber {

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length <= 0)
            return null;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i] + "");
        }

        Collections.sort(list,
                (o1, o2) -> {
                    return (o1 + o2).compareTo(o2 + o1); ////按照降序排列(第一个大于第二个返回1-->升序排列)
                });

        StringBuilder res = new StringBuilder();
        for (String s : list)
            res.append(s);

        return res.toString();
    }

    @Test
    public void test(){
        int[] arr = {3, 32, 321};
        System.out.println(PrintMinNumber(arr));
    }
}

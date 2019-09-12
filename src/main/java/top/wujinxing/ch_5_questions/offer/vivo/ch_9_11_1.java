package top.wujinxing.ch_5_questions.offer.vivo;
import java.io.*;
/**
 * @author wujinxing
 * date 2019 2019/9/11 16:00
 * description 拆礼盒
 *
 * 给一个字符串，（）表示一个礼品盒 0表示奖品，
 * 最少要拆多少个礼品盒才能拿到奖品。
 */
public class ch_9_11_1 {

    public static void main(String[] args) throws Exception {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr );*/
        String inputStr = "(()(()((()(0)))))";
        String inputStr2 = "(((0)))";
        String inputStr3 = "((()()()((0))()()()))";
        int output = solution(inputStr3);
        System.out.println(output);
    }

    private static int solution(String str) {
        char[] c = str.toCharArray();
        int count = 0;
        for (int i=0; i<c.length; i++){
            if (c[i] != '0')
                count++;
            else {
                break;
            }
        }
        int result = count;
        for (int i=0; i<count; i++){
            if (c[i] == '(' && c[i+1] == ')')
                result -= 2;
        }
        return result;
    }
}

package top.wujinxing.ch_5_questions.SwordOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author wujinxing
 * date 2019 2019/9/10 14:55
 * description 字符串的排列
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串`abc`,则打印出由字符`a,b,c`所能排列出来的所有
 * 字符串`abc,acb,bac,bca,cab和cba`。
 *
 * 输入描述：输入一个字符串,长度不超过`9`(可能有字符重复),字符只包括大小写字母。
 *
 * ### 解析
 */
public class ch_27_Permutation {

    private ArrayList<String> res;

    public ArrayList<String> Permutation(String str){
        res = new ArrayList<>();
        if (str==null || str.length() ==0)
            return res;

        rec(str.toCharArray(), 0);
        Collections.sort(res);
        return res;
    }
    //利用set去重
    private void rec(char[] str, int cur){
        if (cur ==str.length -1){
            res.add(String.valueOf(str));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i=cur; i<str.length; i++){
            set.add(str[i]);
            swap(str, cur, i);
            rec(str, cur+1);
            swap(str, cur, i);
        }

    }
    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

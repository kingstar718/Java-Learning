package top.wujinxing.ch_5_questions.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/7/1 10:50
 * description 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class _38_Permutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String str = sc.nextLine();
        ArrayList<String> ret = Permutation(str);
        System.out.println(ret.toString());
    }


    private static ArrayList<String> ret = new ArrayList<>();
    public static ArrayList<String> Permutation(String str){
        if(str.length() == 0){
            return ret;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }
    private static void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s){
        if(s.length()==chars.length){
            ret.add(s.toString());
            return;
        }
        for(int i=0; i<chars.length; i++){
            if(hasUsed[i])
                continue;
            if(i!=0 && chars[i]==chars[i-1] && !hasUsed[i-1])  //保证值不重复
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length()-1);
            hasUsed[i] = false;
        }
    }
}

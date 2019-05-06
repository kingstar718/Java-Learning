package top.wujinxing.offer.viper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujinxing
 * date 2019 2019/5/6 13:50
 * description 字符串组合
 *
 * 题目描述
 * 输入一个字符串，输出该字符串中相邻字符的所有组合。
 * 举个例子，如果输入abc，它的组合有a、b、c、ab、bc、abc。（注意：输出的组合需要去重）（40分）
 * 输入描述:
 * 一个字符串
 * 输出描述:
 * 一行，每个组合以空格分隔，相同长度的组合需要以字典序排序，且去重。
 * 示例1
 * 输入 bac
 * 输出 a b c ac ba bac
 */
public class StringCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.length()<=1){
            System.out.print(str);
        }
        List<String> rst = new ArrayList<>();
        helper(rst, new StringBuffer(), 0, str);
        Collections.sort(rst, (a,b)->a.length()==b.length()?a.compareTo(b):a.length()-b.length());
        for (int i=0; i<rst.size(); i++){
            System.out.print(rst.get(i)+" ");
        }
    }
    private static void helper(List<String> rst, StringBuffer sb, int start, String str){
        if (rst.contains(sb.toString())){
            return;
        }
        if (sb.length()==1){
            rst.add(sb.toString());
        }else if (sb.length()>1&&str.contains(sb.toString())){
            rst.add(sb.toString());
        }
        for (int i=start; i<str.length(); i++){
            sb.append(str.charAt(i));
            helper(rst, sb, i+1, str);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
